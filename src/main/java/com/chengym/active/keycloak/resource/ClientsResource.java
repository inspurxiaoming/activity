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

import org.keycloak.representations.idm.ClientRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author rodrigo.sasaki@icarros.com.br
 */
public interface ClientsResource {

    @Path("{id}")
    public ClientResource get(@PathParam("id") String id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ClientRepresentation clientRepresentation);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> findAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> findByClientId(@QueryParam("clientId") String clientId);



}
