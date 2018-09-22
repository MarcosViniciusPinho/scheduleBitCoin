package br.com.cloudseven.bitcoin.resource;

import br.com.cloudseven.bitcoin.dto.Job;
import br.com.cloudseven.bitcoin.stream.ExcelBuild;
import br.com.cloudseven.bitcoin.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Marcos Pinho
 */
@RestController
@RequestMapping("/jobs")
public class ScheduleResource {

    @Autowired
    private ScheduleService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> start(@RequestBody Job job){
        this.service.start(job.getSegundo() == null ? 5L : job.getSegundo());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Void> stop(HttpServletResponse response) {
        this.service.stop();
        ExcelBuild.build(response, "Variações.xls");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}