import java.util.ArrayList;
import java.util.List;

/**
 * @author lintingjie
 * @date 2020/10/14 10:34
 */
public class sortDemo {


    private Specification<WorkOrderEntity> workOrderEntitySpecification(WorkOrderQueryAO queryAo) {
        Specification<WorkOrderEntity> specification = (Specification<WorkOrderEntity>) (entity, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>(16);
            if (queryAo.getPlanId() != null) {
                list.add(criteriaBuilder.equal(entity.get("planId"), queryAo.getPlanId()));
            }
            if (StringUtils.isNotBlank(queryAo.getOrderName())) {
                list.add(criteriaBuilder.like(entity.get("orderName"), SqlUtil.formatSearchValue(queryAo.getOrderName())));
            }
            if (queryAo.getMaintainBeginTime() != null) {
                list.add(criteriaBuilder.greaterThanOrEqualTo(entity.get("maintainDate"), DateUtil.getTimeSSSBegin(queryAo.getMaintainBeginTime())));
            }
            if (queryAo.getMaintainEndTime() != null) {
                list.add(criteriaBuilder.lessThanOrEqualTo(entity.get("maintainDate"), DateUtil.getTimeSSSEnd(queryAo.getMaintainEndTime())));
            }
            Expression<Integer> caseExp = criteriaBuilder.<Integer>selectCase()
                    .when(
                            criteriaBuilder.or(
                                    criteriaBuilder.equal(entity.get("orderStatus"), OrderStatusEnum.FINISHED.getCode()),
                                    criteriaBuilder.equal(entity.get("orderStatus"), OrderStatusEnum.TERMINATED.getCode())
                            ),
                            1
                    )
                    .otherwise(0);
            //order by case when ( entity.order_status=6 ) or ( entity.order_status=7 ) then 1 else 0 end asc,
            // entity.create_time asc
            criteriaQuery.orderBy(criteriaBuilder.asc(caseExp),criteriaBuilder.asc(entity.get("createTime")));
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        };
        return specification;
    }
}
