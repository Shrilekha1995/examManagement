import { Component, OnInit } from '@angular/core';
import { Question } from '../Model/Question.model';
import { QuestionService } from "src/app/question.service";
import { SubjectService } from "src/app/subject.service";
import { Router, RouterModule } from "@angular/router";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  subjects: any[];
  tests: any[];
  questions: any[];
  questionM = new Question();
  tid: number;
  AddFlag: boolean = true;
  displayFlag: boolean = true;
  id: number;
  constructor(private questionService: QuestionService, private subjectService: SubjectService, private router: Router) {

  }

  ngOnInit() {
     console.log("helooooooooooooo");
  
    this.onSelect();
  }
  onSubmit() {
    console.log(this.questionM);

    console.log(this.tid);

    this.questionService.addQuestion(this.questionM, this.tid).subscribe(
    );
    // else
    //this.router.navigate(['view']);
    //this.router.onSameUrlNavigation;
    
       
    //this.AddFlag=true;
    this.subjectService.AddFlag=true;
      this.subjectService.getAllQuestionByTId(this.tid).subscribe(
        data => {
          this.questions = data;
          console.log(this.questions);
          
        },
        err => {
          console.log(err);
        }

      )
//location.reload();
  }

  DeleteQuestion(questionNo: number) {
    this.questionService.deleteQuestion(questionNo, this.tid).subscribe();
  }

  updateQuestion(question: Question) {
    this.questionService.updateQuestion(question).subscribe();
    this.id=0;
  }
  editQuestion(question: Question) {
    this.id = question.questionNo;
  }

  onAddQuestion() {
    if ( this.subjectService.AddFlag == true) {
      //this.AddFlag = false;
      this.subjectService.AddFlag=false;
    } else {
      //this.AddFlag = true;
      this.subjectService.AddFlag=true;
    }


  }

  getAllTestbySId(sid: number) {
    //console.log("AAAAA")
    console.log(sid);

    this.subjectService.getAllTestbySId(sid).subscribe(
      data => {
        this.tests = data;
      },
      err => {
        console.log(err);
      }
    )
  }
  getAllQuestionByTId(tid: number) {

    //this.displayFlag = false;
    this.subjectService.displayFlag=false;
    if (tid > 0) {
      this.tid = tid;
      this.subjectService.getAllQuestionByTId(tid).subscribe(
        data => {
          this.questions = data;
          console.log(this.questions);
        },
        err => {
          console.log(err);
        }

      )
    }
  }

  onSelect() {
    this.subjectService.getAllSubjects().subscribe(

      data => {

        this.subjects = data;
        console.log(this.subjects);
      }
      , err => {
        console.log(err);
      }
    )
  }
}

