package com.linkedin.common.urn;

import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WorkflowUrn extends Urn {

    public static final String ENTITY_TYPE = "workflow";

    private static final Pattern URN_PATTERN = Pattern.compile("^" + URN_PREFIX + ENTITY_TYPE + ":(\\w+)$");

    private final String nameEntity;

    public WorkflowUrn(String name) {
        super(ENTITY_TYPE, name);
        this.nameEntity = name;
    }

    public String getNameEntity() {
        return nameEntity;
    }

    public static WorkflowUrn createFromString(String rawUrn) throws URISyntaxException {
        String name = new Urn(rawUrn).getContent();
        return new WorkflowUrn(name);
    }

    public static WorkflowUrn createFromUrn(Urn urn) throws URISyntaxException {
        if (!ENTITY_TYPE.equals(urn.getEntityType())) {
            throw new URISyntaxException(urn.toString(), "Can't cast URN to WorkflowUrn, not same ENTITY");
        }

        Matcher matcher = URN_PATTERN.matcher(urn.toString());
        if (matcher.find()) {
            return new WorkflowUrn(matcher.group(1));
        } else {
            throw new URISyntaxException(urn.toString(), "WorkflowUrn syntax error");
        }
    }
}
