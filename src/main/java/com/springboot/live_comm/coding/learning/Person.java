package com.springboot.live_comm.coding.learning;

import lombok.ToString;

import java.util.*;

@ToString
public class Person {
    private String name;
    private int age;
    private int pp;

    public Person(String name, int age, int pp) {
        this.name = name;
        this.age = age;
        this.pp = pp;
    }

    // 只重写了equals方法，没有重写hashCode方法
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }


    public static void main(String[] args) {
        Person p1 = new Person("John", 20, 1);
        Person p2 = new Person("John", 20, 2);

        // 应该输出true，但是因为没重写hashCode，所以输出false
        System.out.println(p1.equals(p2)); //

        Map<Person, Integer> map = new HashMap<>();
        map.put(p1, 1);
        System.out.println(map.containsKey(p2));
        System.out.println(map);
        map.put(p2, 2);
        System.out.println(map);
        Person p3 = new Person("John", 20, 3);
        System.out.println(map.get(p3));

        // 如果同时重写了equals和hashCode，那么输出true
        // @Override
        // public int hashCode() {
        //     return Objects.hash(name, age);
        // }
    }
    SP231128364602	PGC0008	PGC0044	PGC0337	CL3600105660240BA	工业普圆 20# 2*3 (FB) (40/40) 包钢	CD0011		2*3	330	660.000	300	198000.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/48117120-ed8c-410b-aac4-69fb8bcc10c6.jpg	PGC0008	CK231118443197	FW0002		2	102	QY010760	3	30	40		30.00000	PC231128449561	WL120559		2	2023-11-28 11:54:30	1	梦奇·DH·老七	2023-11-28 11:54:30	1	梦奇·DH·老七	1	1	是	0	否	0	否	SPH231128312890	2	0	1	全部
    SP231127542945	PGC0003	PGC0019	PGC0279	CL1100201753120TY	电镀锌 SECC 1.0*2*5 (FC) (20/20) 通阳达	CD0001	PO231127423300-1	1.0*2*5	2.111	189.990	1001.01	190181.88990	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/d22b49af-b432-423f-8f29-f70bcbfd561e.jpg	PGC0003	CK231107454649	FW0002		90	102	QY0058106	1	1001.01	20	PO231127423300-1	1001.01000	PC231127467922	WL120540		1	2023-11-27 14:23:51	1	梦奇·DH·老七	2023-11-27 14:23:51	1	梦奇·DH·老七	1	0	否	0	否	0	否	SPH231128312865	2	0	1	全部
    SP231126389023	PGC0002	PGC0016	PGC0131	CL0800205281120CJ	冷轧板 SPCC-SR 3.0*8*8 (FC) (20/20) 长江钢铁	CD0002	PO231126557378-1-1	3.0*8*8	3	36.000	222	7992.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/abaae498-fc24-49be-acf9-525a48479475.jpg	PGC0002	CK231116456735	FW0002		12	102	QY1180016	1	20	20	PO231126557378-1	20.00000	PC231126368548	WL120529		1	2023-11-26 18:10:19	1	梦奇·DH·老七	2023-11-26 18:10:19	1	梦奇·DH·老七	1	0	否	0	否	0	否	SPH231126567805	2	0	1	全部
    SP231119446689	PGC0007	PGC0035	PGC0319	CL270010000800ZG	三级抗震螺纹钢 HRB400E 14*9   中天	CD0039	HG-YC20230725-2	14*9	1.83	376.980	3850	1451373.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/ab051214-80fc-4b5d-abe4-46cc12b77419.jpg	PGC0007	CK0001	FW0003,FW0002		206	102	12	0	3848	0		3848.00000	PC231119549182	WL109677		0	2023-11-19 21:12:52	1	梦奇·DH·老七	2023-11-19 21:12:52	1	梦奇·DH·老七	1	0	否	0	否	0	否	SPH231119568122	2	0	1	全部
    SP231119446604	PGC0007	PGC0036	PGC0321	CL2800105352120CJ	三级盘螺 HRB400 3 (FC) (20/20) 长江钢铁	CD0002	PO231119347736-1-1	3	4	84.000	300	25200.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/6f759762-43be-41ac-a03d-8ebf3cc81ceb.jpg	PGC0007	CK231116456735	FW0002		21	102	QY1179946	0	100	20	PO231119347736-1	100.00000	PC231119549154	WL120416		1	2023-11-19 09:24:37	1	梦奇·DH·老七	2023-11-19 09:24:37	1	梦奇·DH·老七	1	1	是	0	否	0	否	SPH231125360584	2	0	1	全部	02	02	02	0	01	1	1	1	123	技术标准
    SP231117300822	PGC0007	PGC0036	PGC0321	CL2800105352120CJ	三级盘螺 HRB400 3 (FC) (20/20) 长江钢铁	CD0002	PO231115480024-1-1	3	2	4.000	122	488.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20220811/6f759762-43be-41ac-a03d-8ebf3cc81ceb.jpg	PGC0007	CK230817560969	FW0002		2	102	QY1179950	0	100	20	PO231115480024-1	100.00000	PC231117411148	WL120416		1	2023-11-17 10:03:01	1	梦奇·DH·老七	2023-11-17 10:03:01	1	梦奇·DH·老七	1	0	否	0	否	0	否	SPH231119548146	2	0	1	全部
    SP231029338619	PGC0005	PGC0567	PGC0600	CL4000101727120ME	等边角钢 Q235B 1.0*1*1 (FC) (20/20) 梅钢	CD0022	PO231029408066-1	1.0*1*1	10	840.000	10	8400.00000	https://s3-zz-prda.sail-cloud.com/bailian-oss-prd-private-dhqc1gygs/catagory/20221114/1668409418671/5%E3%80%81%E5%9E%8B%E9%92%A2-%E8%A7%92%E9%92%A2.jpg	PGC0005	CK0236	FW0002		84	102	QY0058106	1	10	20	PO231029408066	10.00000	PC231029577119	WL120160		1	2023-10-29 21:32:37	1	梦奇·DH·老七	2023-10-29 21:32:37	1	梦奇·DH·老七	1	0	否	0	否	0	否	SPH231029578080	2	0	1	全部
}