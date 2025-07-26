package com.larina.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.larina.model.Employee;
import com.larina.model.Role;
import com.larina.model.Stand;
import com.larina.model.StandsGroup;
import com.larina.model.StandsGroupRelation;
import com.larina.model.Status;
import com.larina.repositories.*;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private StandGroupRepository standGroupRepository;

	@Autowired
	private StandsGroupRelationRepository standsGroupRelationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private StandsRepository standsRepository;

	@Autowired
	private StatusesRepository statusesRepository;

	@Autowired
	private RolesRepository rolesRepository;

	DataInitializer(StandGroupRepository standGroupRepository) {
		this.standGroupRepository = standGroupRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		initAll();
	}

	private void initAll() {
		StandsGroup main = new StandsGroup("All Stands");
		// groups for generated data
		StandsGroup generated = new StandsGroup("Generated");
		StandsGroup linuxGen = new StandsGroup("Linux Stands");
		StandsGroup windowsGen = new StandsGroup("Windows Stands");
		StandsGroup titanStandsLinux = new StandsGroup("Test1 Stands");
		StandsGroup cilkPacStandsLinux = new StandsGroup("Test2 Stands");
		StandsGroup titanStandsWindows = new StandsGroup("Test1 Stands");
		StandsGroup cilkPacStandsWindows = new StandsGroup("Test2 Stands");

		// groups for real data
		StandsGroup userDefined = new StandsGroup("User Defined");
		
		StandsGroup linux = new StandsGroup("Linux Stands");
		StandsGroup windows = new StandsGroup("Windows Stands");
		
		StandsGroup titanStandsLinuxUD = new StandsGroup("Test1 Stands");
		StandsGroup cilkPacStandsLinuxUD = new StandsGroup("Test2 Stands");
		
		StandsGroup titanStandsWindowsUD = new StandsGroup("Test1 Stands");
		StandsGroup cilkPacStandsWindowsUD = new StandsGroup("Test2 Stands");
		
		standGroupRepository.saveAll(List.of(main, generated, linuxGen, windowsGen, titanStandsLinux,
				titanStandsWindows, cilkPacStandsLinux, cilkPacStandsWindows, userDefined, linux, windows,
				titanStandsLinuxUD, titanStandsWindowsUD, cilkPacStandsLinuxUD, cilkPacStandsWindowsUD));

		
		StandsGroupRelation r1 = new StandsGroupRelation(main.getId(), generated.getId());
		StandsGroupRelation r2 = new StandsGroupRelation(generated.getId(), linuxGen.getId());
		StandsGroupRelation r3 = new StandsGroupRelation(generated.getId(), windowsGen.getId());
		StandsGroupRelation r4 = new StandsGroupRelation(linuxGen.getId(), titanStandsLinux.getId());
		StandsGroupRelation r5 = new StandsGroupRelation(linuxGen.getId(), cilkPacStandsLinux.getId());
		StandsGroupRelation r6 = new StandsGroupRelation(windowsGen.getId(), titanStandsWindows.getId());
		StandsGroupRelation r7 = new StandsGroupRelation(windowsGen.getId(), cilkPacStandsWindows.getId());
		StandsGroupRelation r8 = new StandsGroupRelation(main.getId(), userDefined.getId());
		StandsGroupRelation r9 = new StandsGroupRelation(userDefined.getId(), linux.getId());
		StandsGroupRelation r10 = new StandsGroupRelation(userDefined.getId(), windows.getId());
		StandsGroupRelation r11 = new StandsGroupRelation(linux.getId(), titanStandsLinuxUD.getId());
		StandsGroupRelation r12 = new StandsGroupRelation(linux.getId(), cilkPacStandsLinuxUD.getId());
		StandsGroupRelation r13 = new StandsGroupRelation(windows.getId(), titanStandsWindowsUD.getId());
		StandsGroupRelation r14 = new StandsGroupRelation(windows.getId(), cilkPacStandsWindowsUD.getId());
		

		standsGroupRelationRepository.saveAll(List.of(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14));

		Employee e1 = new Employee("petrpetrov", "Petr", "Petrov");
		Employee e2 = new Employee("ivanivanov", "Ivan", "Ivanov");
		Employee e3 = new Employee("sidorsidorov", "Sidor", "Sidorov");
		Employee e4 = new Employee("sidorsidorov2", "Sidor", "Sidorov2");
		Employee e5 = new Employee("ivanivanov2", "Ivan", "Ivanov2");
		employeeRepository.saveAll(List.of(e1, e2, e3, e4, e5));

		Stand s1 = new Stand("Белка", "111.111.111.111", "uio", "1234", cilkPacStandsWindowsUD);
		Stand s2 = new Stand("Бобик", "111.111.111.112", "uio", "1234", cilkPacStandsWindowsUD);
		Stand s3 = new Stand("Стрелка", "111.111.111.113", "uio", "1234", cilkPacStandsLinuxUD);
		standsRepository.saveAll(List.of(s1, s2, s3));

		for (int i = 0; i < 30; i++) {
			Stand s = new Stand("Stand Stand Stand " + i, "111.111.111.111", "user" + i, "1234", generated);
			standsRepository.save(s);
		}

		Role role1 = new Role("user");
		Role role2 = new Role("admin");
		rolesRepository.saveAll(List.of(role1, role2));

		Status status1 = new Status(e1.getId(), s1.getId(), true);
		statusesRepository.save(status1);

	}

}
