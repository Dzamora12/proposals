package com.bbva.pzic.proposals.v0.processtasks.facade.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.pzic.proposals.v0.processtasks.business.ISrvIntProposalsV0Processtasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.ISrvProposalsV0Processtasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.mapper.IListProcessTasksProposalsMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v0")
@Produces(MediaType.APPLICATION_JSON)
@SN(registryID = "SNPE1700055", logicalID = "proposals")
@VN(vnn = "v0")
@Service
public class SrvProposalsV0Processtasks implements ISrvProposalsV0Processtasks {

    private static final Log LOG = LogFactory.getLog(SrvProposalsV0Processtasks.class);

    @Autowired
    private IListProcessTasksProposalsMapper listProcessTasksProposalsMapper;

    @Autowired
    private ISrvIntProposalsV0Processtasks srvIntProposalsV0Processtasks;

    @GET
    @Path("/process-tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMGG20203823", logicalID = "listProcessTasksProposals", forcedCatalog = "gabiCatalog")
    @Override
    public ServiceResponse<ProcessTasks> listProcessTasksProposals(@QueryParam("businessProcessId") final String businessProcessId,
                                                                   @QueryParam("taskId") final String taskId) {

        LOG.info("----- SrvProposalsV0Processtasks.listProcessTasksProposals -----");

        ServiceResponse<ProcessTasks> serviceResponse = listProcessTasksProposalsMapper.mapOut(
          srvIntProposalsV0Processtasks.listProcessTasksProposals(
                  listProcessTasksProposalsMapper.mapIn(businessProcessId, taskId)
          )
        );



        return serviceResponse;
    }
}
