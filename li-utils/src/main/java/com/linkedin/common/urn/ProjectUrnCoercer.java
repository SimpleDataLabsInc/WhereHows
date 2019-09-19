package com.linkedin.common.urn;

import com.linkedin.data.template.Custom;
import com.linkedin.data.template.DirectCoercer;
import com.linkedin.data.template.TemplateOutputCastException;
import java.net.URISyntaxException;


public class ProjectUrnCoercer implements DirectCoercer<ProjectUrn> {

    private static final boolean REGISTER_COERCER = Custom.registerCoercer(new ProjectUrnCoercer(), ProjectUrn.class);

    public ProjectUrnCoercer() {
    }

    public Object coerceInput(ProjectUrn object) throws ClassCastException {
        return object.toString();
    }

    public ProjectUrn coerceOutput(Object object) throws TemplateOutputCastException {
        try {
            return ProjectUrn.createFromString((String) object);
        } catch (URISyntaxException e) {
            throw new TemplateOutputCastException("Invalid URN syntax: " + e.getMessage(), e);
        }
    }
}
