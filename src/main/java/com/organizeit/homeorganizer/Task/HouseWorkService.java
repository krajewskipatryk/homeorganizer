package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.TaskType.TaskType;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
class HouseWorkService {
    private final HouseWorkRepository houseWorkRepository;
    public HouseWork createHouseWork(Group group) {
        HouseWork houseWork = HouseWork.builder()
                .id(UUID.randomUUID())
                .group(group)
                .taskList(new HashSet<>())
                .taskHistory(new HashSet<>())
                .build();

        houseWorkRepository.save(houseWork);

        return houseWork;
    }

    public Set<TaskType> getTaskList(UUID id) {
        return this.getHouseWorkEntity(id).getTaskList();
    }

    public Set<TaskHistory> getTaskHistory(UUID id) {
        return this.getHouseWorkEntity(id).getTaskHistory();
    }

    public void updateHouseWorkStatus(HouseWork houseWork) {
        houseWorkRepository.save(houseWork);
    }

    public HouseWork getHouseWorkEntity(UUID id) {
        return houseWorkRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("ni ma");
        });
    }

    public void deleteTask(UUID houseWorkId, TaskType task) {
        HouseWork houseWork = this.getHouseWorkEntity(houseWorkId);
        houseWork.getTaskList().remove(task);
        houseWorkRepository.save(houseWork);
    }

    public void deleteHouseWork(UUID id) {
        HouseWork houseWork = this.getHouseWorkEntity(id);

        houseWorkRepository.delete(houseWork);
    }
}
