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

import org.keycloak.representations.idm.RealmRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.*;
/**
 * @author rodrigo.sasaki@icarros.com.br
 */
@Path("/admin/realms")
@Consumes(MediaType.APPLICATION_JSON)
public interface RealmsResource {

    @Path("/{realm}")
    public RealmResource realm(@PathParam("realm") String realm);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RealmRepresentation realmRepresentation);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RealmRepresentation> findAll();

}
