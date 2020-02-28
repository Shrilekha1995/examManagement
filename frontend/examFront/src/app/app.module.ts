import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ViewComponent } from './view/view.component';
import { UploadComponent } from './upload/upload.component';
import { QuestionService } from "src/app/question.service";
import { HttpClient, HttpClientModule, HttpHeaders } from "@angular/common/http";
import { SubjectService } from "src/app/subject.service";
import { RouterModule } from "@angular/router";
import { QuestionComponent } from './question/question.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ViewComponent,
    UploadComponent,
    QuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [QuestionService,SubjectService],
  bootstrap: [AppComponent]
})
export class AppModule { }
