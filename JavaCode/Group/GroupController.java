package JavaCode.Group;

import java.util.*;
import java.util.stream.Collectors;
import JavaCode.User.User;

public class GroupController {
    Map<String, Group> mappedGroupList;

    public GroupController() {
        this.mappedGroupList = new HashMap<>();
    }

    public void addGroup(Group group) {
        this.mappedGroupList.put(group.getGroupID(), group);
    }

    public Group createGroup(String groupID, String groupName, User user) {
        Group group = new Group(groupID, groupName);
        addGroup(group);
        group.addGroupMember(user);

        return group;
    }

    public Group searchGroup(String groupID) {
        return this.mappedGroupList.get(groupID);
    }

    public List<Group> getAllGroups() {
        Collection<Group> groupCollectionObject = this.mappedGroupList.values();
        List<Group> groupList = groupCollectionObject.stream().collect(Collectors.toList());

        return groupList;
    }
}
