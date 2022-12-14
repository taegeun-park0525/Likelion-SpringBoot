package com.springboot.hello.parser;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import com.springboot.hello.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest//(classes = ParserFactory.class)// new 연산자를 사용하지 않아도 해당 클래스의 Bean을 찾아 실행한다.
class HospitalParserTest {
    String filename = "C:\\Users\\taege\\git\\hello\\src\\main\\resources\\static\\hospitaldata.csv";
    HospitalParser hp = new HospitalParser();

    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620001\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
    String line2 = "\"2\",\"의원\",\"01_01_02_P\",\"3620002\",\"PHMA119993620020041100005\",\"19990610\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
    String line3 = "\"3\",\"의원\",\"01_01_02_P\",\"3620003\",\"PHMA119993620020041100006\",\"19990611\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext; //아래처럼 new를 하지 않아도 SpringBootTest가 Autowired에 적용된 곳에 Bean을 찾아 적용해준다.
    //ReadLineContext<Hospital> hospitalReadLineContext = new ParserFactory().hospitalReadLineContext();

    @Autowired //HospitalDao는 Factory도 없는데 왜 DI가 되는것인가 -> @COMPONET가 다해줌ㅋ
    HospitalDao hospitalDao;

    @Autowired
    HospitalService hospitalService;

    @Test
    @DisplayName("HospitalDao가 잘되는지")
    void addAndGet() {
//        HospitalParser hp = new HospitalParser();
//        hospitalDao.deleteAllHospital();
//        Hospital hospital1 = hp.parse(line1);
//        Hospital hospital2 = hp.parse(line2);
//        Hospital hospital3 = hp.parse(line3);
//        hospitalDao.addHospital(hospital1);
//        hospitalDao.addHospital(hospital2);
//        hospitalDao.addHospital(hospital3);
//        hospitalDao.deleteHospital(1);
//        assertEquals(2, hospitalDao.getCountHospital());
//
//        Hospital selectedHospital = hospitalDao.findByIdHospital(hospital2.getId());
//        //ID가 제대로 입력됐는지
//        assertEquals(hospital2.getId(), selectedHospital.getId());
//        //날짜가 제대로 입력됐는지
//        assertEquals(selectedHospital.getLicenseData(), hospital2.getLicenseData());
//        //float이 제대로 입력됐는지
//        assertEquals(selectedHospital.getTotalAreaSize(), hospital2.getTotalAreaSize());

    }


//    @Test
//    @DisplayName("10만건 이상 데이터가 파싱되는지")
//    void oneHundread() throws IOException {
//        //서버환경에서 build할때 문제가 생길 수 있습니다.
//        //어디에서든지 실행 할 수 있게짜는 것이 목표다.
//        hospitalDao.deleteAllHospital();
//        int cnt = this.hospitalService.insertLargeVolumeHospitalData(filename);
//
//
//        assertTrue(cnt > 1000);
//        assertTrue(cnt > 100000);
//        System.out.printf("파싱된 데이터 개수 : %d\n", cnt);
//    }


//    @Test
//    @DisplayName("csv 1줄을 Hospital로 잘 만드는지 Test")
//    void convertToHospital() {
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(line1);
//        System.out.println(line1);
//        assertEquals(1, hospital.getId()); // col:0
//        assertEquals("의원", hospital.getOpenServiceName());//col:1
//        assertEquals(3620001, hospital.getOpenLocalGovernmentCode()); // col: 3
//        assertEquals("PHMA119993620020041100004", hospital.getManagementNumber()); // col:4
//        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseData()); //19990612 //col:5
//        assertEquals(1, hospital.getBusinessStatus()); //col:7
//        assertEquals(13, hospital.getBusinessStatusCode());//col:9
//        assertEquals("062-515-2875", hospital.getPhone());//col:17
//        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress()); //col:18
//        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());//col:19
//        assertEquals("효치과의원", hospital.getHospitalName());//col:21
//        assertEquals("치과의원", hospital.getBusinessTypeName());//col:25
//        assertEquals(1, hospital.getHealthcareProviderCount());//col : 30
//        assertEquals(0, hospital.getPatientRoomCount()); //col:31
//        assertEquals(0, hospital.getTotalNumberOfBeds()); //col:32
//        assertEquals(52.29f, hospital.getTotalAreaSize()); //col:33
//    }
}