import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartTitleComponent } from './components/cart-title/cart-title.component';
import { SignupComponent } from './componenets/signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    CartTitleComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
