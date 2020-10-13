import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lintingjie
 * @date 2020/10/13 14:09
 */
public class MapDemo {

    public static void main(String[] args) {
        //list转map
        Map<String, List<WorkOrderBaseVO>> urgentMap =
                urgentList.stream().collect(Collectors.toMap(e->DateUtil.formatYMDDate(e.getAssignDate()),
                        e -> Lists.newArrayList(new WorkOrderBaseVO(e, unitNameMap, userMap)),
                        (List<WorkOrderBaseVO> oldList, List<WorkOrderBaseVO> newList) -> {
                            oldList.addAll(newList);
                            return oldList;
                        }));

        //groupBy
        Map<Date, List<WorkOrderEntity>> dateMap =
                urgentList.stream().collect(Collectors.groupingBy(WorkOrderEntity::getMaintainDate));

        Map<String, List<WorkOrderEntity>> dateStrMap =
                urgentList.stream().collect(Collectors.groupingBy(e -> DateUtil.formatYMDDate(e.getMaintainDate())));

        //把收集器的结果转换为另一种类型
        Map<String, List<WorkOrderBaseVO>> map =
                urgentList.stream().collect(Collectors.groupingBy(e -> DateUtil.formatYMDDate(e.getAssignDate()),
                        Collectors.mapping(e -> new WorkOrderBaseVO(e, unitNameMap, userMap), Collectors.toList())));
    }
}
