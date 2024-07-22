package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.service.AcademicDetails.AcademicDetailsService;

import java.util.List;

@RestController
@RequestMapping("/AcademicDetails")
public class AcademicDetailsController {
  @Autowired
    private AcademicDetailsService academicDetailsService;

  @PostMapping("/create")
  public AcademicDetails create( @RequestBody AcademicDetails academicDetails) {
      return academicDetailsService.create(academicDetails);
  }

  @GetMapping("/read/{id}")
  public ResponseEntity read(@PathVariable String id) {
      if (id == null) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      AcademicDetails academicDetails = academicDetailsService.read(id);

      if (academicDetails == null) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(academicDetails, HttpStatus.OK);
  }

  @PostMapping("/update")
  public  AcademicDetails update(@RequestBody AcademicDetails academicDetails) {
      return academicDetailsService.update(academicDetails);
  }

  @PostMapping("/delete/{id}")
  public Boolean delete(@PathVariable String id) {
      return academicDetailsService.delete(id);
  }

  @GetMapping("/getAll")
  public List<AcademicDetails> getAll() {
      return academicDetailsService.getAll();
  }

}
