package org.coode.www.controller;

import org.coode.www.kit.OWLHTMLKit;
import org.coode.www.model.ApplicationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

abstract public class ApplicationController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected ApplicationInfo applicationInfo;

    @Autowired
    protected OWLHTMLKit kit;

    @ModelAttribute("applicationInfo")
    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    @ModelAttribute("kit")
    public OWLHTMLKit getKit() { return kit; }
}
