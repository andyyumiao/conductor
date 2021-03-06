/*
 * Copyright 2020 Netflix, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.netflix.conductor.core.exception;

import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.run.Workflow.WorkflowStatus;

public class TerminateWorkflowException extends RuntimeException {

    private final WorkflowStatus workflowStatus;
    private final Task task;

    public TerminateWorkflowException(String reason) {
        this(reason, WorkflowStatus.FAILED);
    }

    public TerminateWorkflowException(String reason, WorkflowStatus workflowStatus) {
        this(reason, workflowStatus, null);
    }

    public TerminateWorkflowException(String reason, WorkflowStatus workflowStatus, Task task) {
        super(reason);
        this.workflowStatus = workflowStatus;
        this.task = task;
    }

    public WorkflowStatus getWorkflowStatus() {
        return workflowStatus;
    }

    public Task getTask() {
        return task;
    }
}
