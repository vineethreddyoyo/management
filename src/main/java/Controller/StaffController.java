package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.HotelRepository;
import com.example.management.Staff;
import com.example.management.StaffRepository;

import Services.StaffService;

@RestController
public class StaffController {

@Autowired
StaffRepository sr;
@Autowired
HotelRepository hr;

@Autowired
StaffService ss;

@RequestMapping("/create_staff")
public String Create()
{
	Staff s = new Staff((long) 1,"vineeth",5000);
	s.setHotel(hr.getOne((long) 1));
	sr.save(s);
	return "staff created";
}
@RequestMapping("get_staff_cluster")
public String getStaff_Cluster()
{
	
return sr.getOne((long) 1).getHotel().getCluster().getClusterName();
}

@RequestMapping("/allocate")
public String allocate() {
	
	ss.allocate((long) 2);

	return "allocated";
}

/*
@RequestMapping("/findbyid")
public String check()
{
	Set<Staff> staffs = hr.findByTotal_rooms((long) 1);
	for (Iterator<Staff> it = staffs.iterator(); it.hasNext(); ) {
        Staff f = it.next();
        System.out.println(f.getName());
    }
	return "Staff allocated";
}
*/
	
}