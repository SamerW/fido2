/**
 * Copyright StrongAuth, Inc. All Rights Reserved.
 *
 * Use of this source code is governed by the Gnu Lesser General Public License 2.3.
 * The license can be found at https://github.com/StrongKey/fido2/LICENSE
 */
package com.strongkey.apiws.filters;

import com.strongkey.appliance.utilities.applianceCommon;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CrossOriginResourceSharingFilter implements ContainerResponseFilter {

    private static final String ALLOWEDHOSTS = applianceCommon.getApplianceConfigurationProperty("applicance.cfg.property.accesscontrolalloworigins");
    private static final String ALLOWEDMETHODS= applianceCommon.getApplianceConfigurationProperty("applicance.cfg.property.accesscontrolallowmethods");
    private static final String ALLOWEDHEADERS = applianceCommon.getApplianceConfigurationProperty("applicance.cfg.property.accesscontrolallowheaders");

    private static final List<String> ALLOWEDHOSTSLIST = (ALLOWEDHOSTS != null && !ALLOWEDHOSTS.isEmpty())
            ? Arrays.asList(ALLOWEDHOSTS.split("\\s*,\\s*"))
            : null;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String origin = requestContext.getHeaderString("Origin");
        if (ALLOWEDHOSTSLIST != null) {
            if (ALLOWEDHOSTSLIST.contains(origin)) {
                responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", origin);
                responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", ALLOWEDMETHODS);
                responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", ALLOWEDHEADERS);
                responseContext.getHeaders().putSingle("Vary", "Origin");
            }
        }
    }

}
