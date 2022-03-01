package com.bbva.pzic.proposals.v0.processtasks.dao.impl;

import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.IProposalsDAOV0ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.ApxListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalDAOV0ProcessTasks implements IProposalsDAOV0ProcessTasks {

    private static final Log LOG = LogFactory.getLog(ProposalDAOV0ProcessTasks.class);

    @Autowired
    private ApxListProcessTasksProposals apxListProcessTasksProposals;

    @Override
    public ProcessTasks listProcessTasksProposals(InputListProcessTasksProposals input) {
        LOG.info("... Invoking method ProposalDAOV0ProcessTasks.listProcessTasksProposals APX ...");

        return apxListProcessTasksProposals.perform(input);
    }
}
