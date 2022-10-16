/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package oidc.client.differentProviders.servlets;

import jakarta.annotation.security.DeclareRoles;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.openid.ClaimsDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.openid.OpenIdProviderMetadata;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import oidc.client.base.servlets.BaseServlet;

@WebServlet("/Provider2Servlet")
@OpenIdAuthenticationMechanismDefinition(providerURI = "${providerBean.providerSecureRoot}/oidc/endpoint/OP2", clientId = "client_1",
                                         clientSecret = "mySharedKeyNowHasToBeLongerStrongerAndMoreSecureAndForHS512EvenLongerToBeStronger",
                                         claimsDefinition = @ClaimsDefinition(callerNameClaim = "sub", callerGroupsClaim = "groupIds"),
                                         redirectURI = "${baseURL}/Callback",
                                         providerMetadata = @OpenIdProviderMetadata(authorizationEndpoint = "${providerBean.providerSecureRoot}/oidc/endpoint/OP2/authorize",
                                                                                    tokenEndpoint = "${providerBean.providerSecureRoot}/oidc/endpoint/OP2/token"))
@DeclareRoles("all")
@ServletSecurity(@HttpConstraint(rolesAllowed = "all"))
public class Provider2Servlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

}
