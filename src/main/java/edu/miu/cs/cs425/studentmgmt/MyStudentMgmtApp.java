package edu.miu.cs.cs425.studentmgmt;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassRoomService;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {
	private StudentService studentService;
	private TranscriptService transcriptService;
	private ClassRoomService classRoomService;
	private CourseService courseService;

	public MyStudentMgmtApp(StudentService studentService, TranscriptService transcriptService,
			ClassRoomService classRoomService, CourseService courseService) {
		this.studentService = studentService;
		this.transcriptService = transcriptService;
		this.classRoomService = classRoomService;
		this.courseService = courseService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		final Course course = new Course(null, "CS401", "Modern Prog Practices", null);
		courseService.saveCourse(course);

		final Classroom classroom = classRoomService
				.saveClassRoom(new Classroom(null, "McLaughlin building", "M105", null));

		final Transcript transcript = transcriptService.saveTranscript(new Transcript(null, "BS Computer Science"));
		final Transcript transcript2 = transcriptService.saveTranscript(new Transcript(null, "BS Computer Science 2"));

		final Student student1 = studentService
				.saveStudent(new Student(null, "10", "Maged 1", "Ahmed 1", "Rashed 1", 4.0, new Date(),
						transcript, classroom, List.of(course)));

		final Student student2 = studentService
				.saveStudent(new Student(null, "11", "Maged 2", "Ahmed 2", "Rashed 2", 4.0, new Date(),
						transcript2, classroom, List.of(course)));

		System.out.println(transcript);
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(classroom);
		System.out.println(course);
	}

}
