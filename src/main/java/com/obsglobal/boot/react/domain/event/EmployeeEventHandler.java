package com.obsglobal.boot.react.domain.event;

import com.obsglobal.boot.react.domain.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import static com.obsglobal.boot.react.web.WebSocketConfiguration.MESSAGE_PREFIX;

@Component
@RepositoryEventHandler(Employee.class)
@AllArgsConstructor
public class EmployeeEventHandler {
    private final SimpMessagingTemplate webSocket;

    private final EntityLinks entityLinks;

    @HandleAfterCreate
    public void newEmployee(Employee employee) {
        this.webSocket.convertAndSend(MESSAGE_PREFIX + "/newEmployee", getPath(employee));
    }

    @HandleAfterDelete
    public void deleteEmployee(Employee employee) {
        this.webSocket.convertAndSend(MESSAGE_PREFIX + "/deleteEmployee", getPath(employee));
    }

    @HandleAfterSave
    public void updateEmployee(Employee employee) {
        this.webSocket.convertAndSend(MESSAGE_PREFIX + "/updateEmployee", getPath(employee));
    }

    private String getPath(Employee employee) {
        return this.entityLinks.linkForSingleResource(employee.getClass(), employee.getId()).toUri().getPath();
    }
}
