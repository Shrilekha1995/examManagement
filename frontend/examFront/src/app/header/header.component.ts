import { Component, OnInit } from '@angular/core';
import { SubjectService } from "src/app/subject.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private subjectService:SubjectService) { }

  ngOnInit() {
  }
  toggle(){
    this.subjectService.AddFlag=true
    this.subjectService.displayFlag=true
  }
}
