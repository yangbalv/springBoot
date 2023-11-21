package com.springboot.live_comm.coding.learning;

import java.util.*;

/**
 * @ClassName: AA
 * @Author : ever
 * @Date :2023/11/3  11:42
 * @Description: TODO
 * @Version :1.0
 */
public class AA {
    // Definition for a Node.
    class NodeX {
        public int val;
        public List<NodeX> neighbors;

        public NodeX() {
            val = 0;
            neighbors = new ArrayList<NodeX>();
        }

        public NodeX(int _val) {
            val = _val;
            neighbors = new ArrayList<NodeX>();
        }

        public NodeX(int _val, ArrayList<NodeX> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Map<NodeX, NodeX> map = new HashMap<>();

    public NodeX cloneGraph(NodeX node) {
        NodeX newNode;
        if (!map.containsKey(node)) {
            newNode = new NodeX(node.val);
            List<NodeX> nodeXList = new ArrayList<>();
            map.put(node, newNode);
            for (NodeX neighbor : node.neighbors) {
                nodeXList.add(cloneGraph(neighbor));
            }
            newNode.neighbors = nodeXList;
        } else {
            newNode = map.get(node);
        }
        return newNode;
    }

    //    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        if (equations==null||equations.size()!= values.length){
//            return new double[]{};
//        }
//        for (List<String> equation : equations) {
//            String s1 = equation.get(0);
//            String s2 = equation.get(1);
//        }
//
//    }
    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println(aa.equationsPossible2(new String[]{"a==b","b!=a"}));
    }

    public boolean equationsPossible2(String[] equations) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                if (map.get(equation.charAt(0)) == null) {
                    Set<Character> set = new HashSet<>();
                    set.add(equation.charAt(0));
                    map.put(equation.charAt(0), set);
                }
                if (map.get(equation.charAt(3)) == null) {
                    Set<Character> set = new HashSet<>();
                    set.add(equation.charAt(3));
                    map.put(equation.charAt(3), set);
                }
                map.get(equation.charAt(0)).addAll(map.get(equation.charAt(3)));
                for (Character character : map.get(equation.charAt(3))) {
                    map.put(character, map.get(equation.charAt(0)));
                }
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (map.get(equation.charAt(0)) == null && map.get(equation.charAt(3)) == null && equation.charAt(0) == equation.charAt(3)) {
                    return false;
                }
                if (map.get(equation.charAt(0)) != null && map.get(equation.charAt(3)) != null && map.get(equation.charAt(0)) == map.get(equation.charAt(3))) {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean equationsPossible(String[] equations) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Set<Character>> setMap = new HashMap<>();
        Map<Integer, Set<Integer>> upsetDown = new HashMap<>();
        int p = 1;
        for (int i = 0; i < equations.length; i++) {
            char c1 = equations[i].charAt(0);
            char c2 = equations[i].charAt(3);
            p = getP(map, setMap, upsetDown, p, c1);
            p = getP(map, setMap, upsetDown, p, c2);
            Integer c1Num = map.get(c1);
            Integer c2Num = map.get(c2);
            Set<Character> c1Set = setMap.get(c1Num);
            Set<Character> c2Set = setMap.get(c2Num);
            Set<Integer> upsetDownSet1 = upsetDown.get(-c1Num);
            Set<Integer> upsetDownSet2 = upsetDown.get(-c2Num);

            if (equations[i].charAt(1) == '=') {
                if (!c1Num.equals(c2Num)) {
                    if (upsetDown.get(-c1Num).contains(c2Num) || upsetDown.get(-c2Num).contains(c1Num)) {
                        return false;
                    } else {
                        c1Set.addAll(c2Set);
                        upsetDownSet1.addAll(upsetDownSet2);
                        for (Character character : c2Set) {
                            map.put(character, c1Num);
                        }
                    }
                }
            } else {
                upsetDown.get(-c1Num).add(c2Num);
                upsetDown.get(-c2Num).add(c1Num);
                if (map.get(c2).equals(map.get(c1))) {
                    return false;
                }
            }

        }
        return true;
    }

    private int getP(Map<Character, Integer> map, Map<Integer, Set<Character>> setMap, Map<Integer, Set<Integer>> upsetDown, int p, char c2) {
        if (!map.containsKey(c2)) {
            Set<Character> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            set1.add(c2);
            map.put(c2, p);
            setMap.put(p, set1);
            upsetDown.put(-p, set2);
            p++;
        }
        return p;
    }
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('00072381-e607-11ec-8d53-d6e5d31163af', '2', 'SYH000001', 'SYSTEM', '2022-06-07 10:10:28', 'AddNews', '3', '{\"id\":597}', 'SPH0000000800', '', NULL, NULL, NULL, NULL);
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('000a7177-6cc7-11ee-a328-debc2f02495d', '1', 'YH00421140', '淘之夭夭', '2023-10-17 16:27:25', 'CreditProductOpen', '3', '{\"scfId\":\"SXH231007459357\",\"processStatus\":4,\"enterpriseId\":\"QY1070413\",\"protocolType\":1,\"enterpriseName\":\"华晨汽车集团控股有限公司\"}', 'SPH231017556117', '', '2023-10-17 16:28:05', '1', 'DH·name', '15888888888');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('0016cb22-546f-11ed-b83d-ca4adea94be9', '2', 'SYH000001', '王恒豫', '2022-10-25 22:12:04', 'AddNews', '3', '{\"id\":973}', 'SPH0000002929', '', '2022-10-26 09:37:57', 'SYH000010', '沈琦', '15850589150');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('0020f794-7de4-11ee-9d95-86ba78cff07b', '1', 'YH00439780', 'null', '2023-11-08 11:07:50', 'SxgOrderApply', '5', '{\"organizationCode\":\"91110000710929930X\",\"id\":\"XS231108428475\",\"enterpriseId\":\"QY010731\",\"enterpriseName\":\"中国中车集团有限公司\"}', 'SPH231108310488', '买家取消申请,自动关闭审批', '2023-11-08 13:57:40', 'YH00439780', '13332233333', '13332233333');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('00212a51-59da-11ee-9926-9a7742215f04', '2', '1', 'DH·name', '2023-09-23 14:25:33', 'PurchaseDelivery', '3', '{\"agentName\":\"DH·name\",\"createBy\":\"DH·name\",\"createTime\":\"2023-09-23 14:25:33\",\"deliveryAmount\":2,\"deliveryDate\":\"2023-09-23\",\"deliveryId\":\"CGFH230923451821\",\"deliveryType\":\"自提\",\"deliveryWeight\":100.000,\"deptName\":\"南京东华材料科技有限公司\",\"mark\":\"\",\"mustSendPeriod\":\"2023-09\",\"processStatus\":-1,\"processStatusName\":\"-\",\"purchaseDeliveryDetailsBos\":[{\"baleNo\":\"PO230923513944-1\",\"deliveryWeight\":50.000,\"demandProductId\":\"XQ230923373661\",\"grossWeight\":50.000,\"mark\":\"HQ235B\",\"materialName\":\"花纹卷 HQ235B 11.0*11*11  (FC)  (40/40) 包钢\",\"orderId\":\"SO230923421959\",\"origin\":\"包钢\",\"poId\":\"PO230923513944\",\"productDescription\":\"-/-/-/-/-/-/-/-/卷内径(mm):-/-\",\"productForm\":\"板\",\"productId\":\"INVW230923478575\",\"productSurfaceGrade\":\"(FC)\",\"productZincLayer\":\"(40/40)\",\"quantity\":1,\"resourcesNo\":\"PO230923513944\",\"soType\":2,\"soTypeName\":\"期货订单\",\"specifications\":\"11.0*11*11\",\"taxAmount\":2750.000000,\"taxPrice\":55.000,\"taxRate\":0.060,\"variety\":\"热轧板卷\",\"varietyDescription\":\"花纹卷\"},{\"baleNo\":\"PO230923513944-2\",\"deliveryWeight\":50.000,\"demandProductId\":\"XQ230923373661\",\"grossWeight\":50.000,\"mark\":\"HQ235B\",\"materialName\":\"花纹卷 HQ235B 11.0*11*11  (FC)  (40/40) 包钢\",\"orderId\":\"SO230923421959\",\"origin\":\"包钢\",\"poId\":\"PO230923513944\",\"productDescription\":\"-/-/-/-/-/-/-/-/卷内径(mm):-/-\",\"productForm\":\"板\",\"productId\":\"INVW230923478576\",\"productSurfaceGrade\":\"(FC)\",\"productZincLayer\":\"(40/40)\",\"quantity\":1,\"resourcesNo\":\"PO230923513944\",\"soType\":2,\"soTypeName\":\"期货订单\",\"specifications\":\"11.0*11*11\",\"taxAmount\":2750.000000,\"taxPrice\":55.000,\"taxRate\":0.060,\"variety\":\"热轧板卷\",\"varietyDescription\":\"花纹卷\"}],\"purchaseDeliveryLogisticsBos\":[],\"supplyerName\":\"爱神的箭\",\"taxAmount\":5500.000000,\"updateBy\":\"DH·name\",\"updateTime\":\"2023-09-23 14:25:33\",\"warehouseName\":\"安宝库\"}', 'SPH230923383997', '', '2023-09-23 14:25:41', '1', 'DH·name', '15888888888');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('0022a8ff-1498-11ee-9a24-c279b525360a', '2', '1', 'dh', '2023-06-27 11:09:17', 'PutFutures', '3', '{\"id\":293}', 'SPH230627579324', '而他也后即可', '2023-06-27 11:09:30', '1', 'dh', '15888888888');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('00237b95-489b-11ee-bd5d-12db9742721d', '2', 'SYH0004981', '宋想', '2023-09-01 15:41:45', 'AfterSaleApply', '3', '{\"afterSaleAmount\":100.00,\"afterSaleNum\":1,\"afterSaleWeight\":10.000,\"afterStyle\":1,\"afterStyleName\":\"仅退款\",\"afterType\":\"1\",\"afterTypeName\":\"质量异议\",\"afterWhy\":\"不想要了\",\"auditStatus\":-1,\"auditStatusName\":\"-\",\"files\":[{\"afterSaleId\":\"SH230901556641\",\"createBy\":\"兜得住\",\"createTime\":\"2023-09-01 15:35:15\",\"creator\":\"YH0418387\",\"current\":1,\"delFlag\":0,\"fileKind\":0,\"fileUrl\":\"https://s3-zz-prda.sail-cloud.com/bailian-oss-uat-private-dhqc1gygs/V2/afterSale/2023/9/1/1693553673964截屏2023-08-31 20.31.56.png\",\"id\":\"SHWJ000071\",\"params\":{},\"size\":5,\"total\":0,\"updateBy\":\"兜得住\",\"updateTime\":\"2023-09-01 15:35:15\",\"updater\":\"YH0418387\"}],\"id\":\"SH230901556641\",\"orderId\":\"XS230626356833\",\"orderProductDetails\":[{\"applyDetailId\":\"ASD000098\",\"baleNo\":\"\",\"createBy\":\"兜得住\",\"createTime\":\"2023-09-01 15:35:15\",\"creator\":\"YH0418387\",\"current\":1,\"delFlag\":0,\"grossWeight\":10.000,\"markId\":\"PGC0056\",\"markName\":\"QSTE420TM-P\",\"orderId\":\"XS230626356833\",\"params\":{},\"payAfterPrice\":100.00,\"payAfterTotalAmount\":1000.00,\"resourcesNo\":\"666112\",\"returnAmount\":100.00,\"saleAfterStorageNum\":0,\"saleAfterStorageWeight\":0.00,\"size\":5,\"specifications\":\"1.0*2*3\",\"stockId\":\"SP230626478143\",\"stockNum\":1,\"total\":0,\"totalWeight\":10.000,\"unitPrice\":100.00,\"unitTotalAmount\":1000.00,\"updateBy\":\"兜得住\",\"updateTime\":\"2023-09-01 15:35:15\",\"updater\":\"YH0418387\",\"varietyDescriptionId\":\"PGC0010\",\"varietyDescriptionName\":\"酸洗\",\"varietyId\":\"PGC0001\",\"varietyName\":\"热轧板卷\"}],\"orderTagName\":\"预售\",\"returnAmount\":0.00,\"status\":1,\"statusName\":\"待受理\"}', 'SPH230901604123', '', '2023-09-08 13:48:33', '1', 'DH·name', '15888888888');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('00247e6a-616b-11ed-a511-9ae1f50f3a23', '2', '1', 'dh', '2022-11-11 10:46:11', 'PutBidding', '3', '{\"id\":189}', 'SPH0000003054', '', '2022-11-11 10:46:22', '1', 'dh', '15888888888');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('00263c2f-3040-11ee-b17e-3e7759c424c3', '2', 'jack', 'u001', '2023-08-01 15:49:53', 'PurchaseOrder', '3', '{\"agentId\":\"08\",\"agentName\":\"操作员08\",\"areaId\":\"\",\"areaName\":\"\",\"changeRecordsList\":[],\"cityId\":\"\",\"cityName\":\"\",\"closingStatus\":0,\"closingStatusName\":\"未结案\",\"compensationQuantity\":0,\"compensationWeight\":0.000,\"createBy\":\"u001\",\"createTime\":1690876193000,\"creator\":\"jack\",\"deliveryAddr\":\"\",\"deliveryNum\":0,\"deliveryType\":1,\"deliveryTypeName\":\"自提\",\"deptId\":\"12\",\"deptName\":\"采购部12\",\"excessWeight\":0.000,\"poId\":\"PO230801433014\",\"poType\":2,\"poTypeName\":\"期货采购\",\"processStatus\":-1,\"processStatusName\":\"未审批\",\"productList\":[{\"actualTaxIncAmount\":0,\"actualTaxIncPrice\":0.000000,\"compTaxIncludedAmount\":0.000000,\"compensationWeight\":0.000,\"deliveryQuantity\":0,\"deliveryWeight\":0.000,\"demandProductId\":\"XQ230801373376\",\"excessWeight\":0.000,\"grossWeight\":0E-7,\"instockQuantity\":0,\"instockWeight\":0.000,\"mark\":\"SGCC\",\"markId\":\"PGC0280\",\"materialCode\":\"CL1200101765240CJ\",\"materialName\":\"镀铝板 SGCC 1*1*1  (FB)  (40/40) null\",\"originId\":\"CD0002\",\"poItemId\":\"REQPI230801349112\",\"productForm\":\"板\",\"productFormId\":\"1\",\"productSurfaceGrade\":\"(FB)\",\"productSurfaceGradeId\":\"2\",\"productZincLayer\":\"(40/40)\",\"productZincLayerId\":\"40\",\"realProductList\":[{\"instockQuantity\":0,\"instockWeight\":0.000}],\"receiptQuantity\":0,\"receiptWeight\":0.000,\"returnQuantity\":\"0\",\"returnTaxIncludedAmount\":0.000000,\"returnWeight\":0.000,\"soId\":\"SO230801577804\",\"specifications\":\"1*1*1\",\"supplyerName\":\"南京广泽商贸有限公司\",\"taxIncAmount\":12000.000,\"taxPrice\":120.000,\"taxRate\":0.160,\"unreceivedStockQuantity\":0,\"unreceivedStockWeight\":0.000,\"variety\":\"涂镀\",\"varietyDescription\":\"镀铝板\",\"varietyDescriptionId\":\"PGC0020\",\"varietyId\":\"PGC0003\",\"weight\":100.000}],\"provinceId\":\"\",\"provinceName\":\"\",\"quantity\":0,\"remark\":\"SO230801577804\",\"supplyerId\":\"13\",\"supplyerName\":\"南京广泽商贸有限公司\",\"supplyerOrderId\":\"SO230801577804\",\"taxIncAmount\":12000.000,\"unDeliveryWeight\":100.000,\"voucherStatus\":1,\"voucherStatusName\":\"正常\",\"warehouseId\":\"CK0101\",\"warehouseName\":\"直运仓\",\"weight\":100.000}', 'SPH230801447834', '', '2023-08-01 15:50:02', '1', 'dh', '15888888888');
    INSERT INTO ``.`` (`id`, `sponsor_type`, `sponsor_id`, `sponsor_name`, `starting_time`, `process_type`, `status`, `page_param`, `approval_no`, `approval_opinions`, `backup_time`, `backup_operator`, `backup_operate_by`, `backup_operate_phone`) VALUES ('002935eb-1175-11ed-b89d-96626f9f0153', '2', 'SYH000001', 'SYSTEM', '2022-08-01 16:36:13', 'AddNews', '3', '{\"id\":753}', 'SPH0000001228', '', NULL, NULL, NULL, NULL);

}
