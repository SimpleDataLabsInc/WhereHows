package com.linkedin.common.urn;

import com.linkedin.data.template.Custom;
import com.linkedin.data.template.DirectCoercer;
import com.linkedin.data.template.TemplateOutputCastException;
import java.net.URISyntaxException;


public class WorkflowUrnCoercer implements DirectCoercer<WorkflowUrn> {

    private static final boolean REGISTER_COERCER = Custom.registerCoercer(new WorkflowUrnCoercer(), WorkflowUrn.class);

    public WorkflowUrnCoercer() {
    }

    public Object coerceInput(WorkflowUrn object) throws ClassCastException {
        return object.toString();
    }

    public WorkflowUrn coerceOutput(Object object) throws TemplateOutputCastException {
        try {
            return WorkflowUrn.createFromString((String) object);
        } catch (URISyntaxException e) {
            throw new TemplateOutputCastException("Invalid URN syntax: " + e.getMessage(), e);
        }
    }
}
