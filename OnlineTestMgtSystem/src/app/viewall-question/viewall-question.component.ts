import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Question } from '../entity/question';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewall-question',
  templateUrl: './viewall-question.component.html',
  styleUrls: ['./viewall-question.component.css']
})
export class ViewallQuestionComponent implements OnInit {

  questions:any;
  answers:any;
  constructor(private service:QuestionService,private router:Router) { }
  ngOnInit() {
    let resp=this.service.getQuestions();
    resp.subscribe((data)=>this.questions=data);
  }
  public delQuestion(qid){
    alert("Are you sure you want to delete question");
    let resp= this.service.deleteQuestion(qid);
    resp.subscribe((data)=>this.questions=data);
   }
}
