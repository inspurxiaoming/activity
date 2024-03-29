/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chengym.active.keycloak.resource;

import org.keycloak.representations.idm.*;

import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * @author rodrigo.sasaki@icarros.com.br
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource {

    @GET
    public UserRepresentation toRepresentation();

    @PUT
    public void update(UserRepresentation userRepresentation);

    @DELETE
    public void remove();

    @Path("groups")
    @GET
    List<GroupRepresentation> groups();

    @Path("groups/{groupId}")
    @PUT
    Response joinGroup(@PathParam("groupId") String groupId);

    @Path("groups/{groupId}")
    @DELETE
    Response leaveGroup(@PathParam("groupId") String groupId);




    @POST
    @Path("logout")
    public void logout();

    @PUT
    @Path("remove-totp")
    public void removeTotp();

    /**
     * Disables or deletes all credentials for specific types.
     * Type examples "otp", "password"
     *
     *
     * @param credentialTypes
     */
    @Path("disable-credential-types")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void disableCredentialType(List<String> credentialTypes);

    @PUT
    @Path("reset-password")
    public Response resetPassword(CredentialRepresentation credentialRepresentation);

    /**
     * Use executeActionsEmail and pass in the UPDATE_PASSWORD required action
     *
     */
    @PUT
    @Path("reset-password-email")
    @Deprecated
    public void resetPasswordEmail();

    /**
     * Use executeActionsEmail and pass in the UPDATE_PASSWORD required action
     *
     */
    @PUT
    @Path("reset-password-email")
    @Deprecated
    public void resetPasswordEmail(@QueryParam("client_id") String clientId);

    /**
     * Sends an email to the user with a link within it.  If they click on the link they will be asked to perform some actions
     * i.e. reset password, update profile, etc.
     *
     *
     * @param actions
     */
    @PUT
    @Path("execute-actions-email")
    public void executeActionsEmail(List<String> actions);

    /**
     * Sends an email to the user with a link within it.  If they click on the link they will be asked to perform some actions
     * i.e. reset password, update profile, etc.
     *
     * If redirectUri is not null, then you must specify a client id.  This will set the URI you want the flow to link
     * to after the email link is clicked and actions completed.  If both parameters are null, then no page is linked to
     * at the end of the flow.
     *
     * @param clientId
     * @param redirectUri
     * @param actions
     */
    @PUT
    @Path("execute-actions-email")
    public void executeActionsEmail(@QueryParam("client_id") String clientId, @QueryParam("redirect_uri") String redirectUri, List<String> actions);

    @PUT
    @Path("send-verify-email")
    public void sendVerifyEmail();

    @PUT
    @Path("send-verify-email")
    public void sendVerifyEmail(@QueryParam("client_id") String clientId);

    @GET
    @Path("sessions")
    public List<UserSessionRepresentation> getUserSessions();

    @GET
    @Path("offline-sessions/{clientId}")
    List<UserSessionRepresentation> getOfflineSessions(@PathParam("clientId") String clientId);

    @GET
    @Path("federated-identity")
    public List<FederatedIdentityRepresentation> getFederatedIdentity();

    @POST
    @Path("federated-identity/{provider}")
    public Response addFederatedIdentity(@PathParam("provider") String provider, FederatedIdentityRepresentation rep);

    @Path("federated-identity/{provider}")
    @DELETE
    public void removeFederatedIdentity(final @PathParam("provider") String provider);

    @Path("role-mappings")
    public RoleMappingResource roles();


    @GET
    @Path("consents")
    public List<Map<String, Object>> getConsents();

    @DELETE
    @Path("consents/{client}")
    public void revokeConsent(@PathParam("client") String clientId);

    @POST
    @Path("impersonation")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> impersonate();
}
