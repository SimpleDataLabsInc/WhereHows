package com.linkedin.common.urn;

import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ProjectUrn extends Urn {

    public static final String ENTITY_TYPE = "project";

    private static final Pattern URN_PATTERN = Pattern.compile("^" + URN_PREFIX + ENTITY_TYPE + ":(\\w+)$");

    private final String nameEntity;

    public ProjectUrn(String name) {
        super(ENTITY_TYPE, name);
        this.nameEntity = name;
    }

    public String getNameEntity() {
        return nameEntity;
    }

    public static ProjectUrn createFromString(String rawUrn) throws URISyntaxException {
        String name = new Urn(rawUrn).getContent();
        return new ProjectUrn(name);
    }

    public static ProjectUrn createFromUrn(Urn urn) throws URISyntaxException {
        if (!ENTITY_TYPE.equals(urn.getEntityType())) {
            throw new URISyntaxException(urn.toString(), "Can't cast URN to ProjectUrn, not same ENTITY");
        }

        Matcher matcher = URN_PATTERN.matcher(urn.toString());
        if (matcher.find()) {
            return new ProjectUrn(matcher.group(1));
        } else {
            throw new URISyntaxException(urn.toString(), "ProjectUrn syntax error");
        }
    }
}
