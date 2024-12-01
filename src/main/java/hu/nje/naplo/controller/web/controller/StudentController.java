//package hu.nje.naplo.controller.web;
//
//import hu.nje.naplo.entity.Student;
//import hu.nje.naplo.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/students")
//public class StudentController {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
//        Optional<Student> student = studentRepository.findById(id);
//        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
//        return studentRepository.findById(id).map(student -> {
//            student.setStudentName(studentDetails.getStudentName());
//            student.setClassName(studentDetails.getClassName());
////            student.setMen(studentDetails.getMen());
//            return ResponseEntity.ok(studentRepository.save(student));
//        }).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
//        if (studentRepository.existsById(id)) {
//            studentRepository.deleteById(id);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @GetMapping("/delete/{id}")
//    public String confirmDeleteStudent(@PathVariable("id") Integer id, Model model) {
//        Optional<Student> student = studentRepository.findById(id);
//        if (student.isPresent()) {
//            model.addAttribute("student", student.get());
//            return "delete_student";
//        } else {
//            model.addAttribute("error", "A megadott ID-val nem található diák.");
//            return "error";
//        }
//    }
//
////    @PostMapping("/delete/{id}")
////    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
////        boolean success = studentRepository.deleteById(id);
////        if (success) {
////            redirectAttributes.addFlashAttribute("message", "Diák sikeresen törölve.");
////            return "redirect:/students/list";
////        } else {
////            redirectAttributes.addFlashAttribute("error", "Hiba történt a törlés során.");
////            return "redirect:/students/list";
////        }
////    }
//
////    @GetMapping("/classes")
////    public String getClasses(Model model) {
////        List<String> classes = StudentRepository.findByClassName();
////        model.addAttribute("classes", classes);
////        return "add_student"; // A nézet neve
////    }
//}
