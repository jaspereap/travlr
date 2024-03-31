import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login-main/login/login.component';
import { MainComponent } from './main/home/home.component';
import { RegisterComponent } from './auth/register/register.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { LogoutComponent } from './auth/logout/logout.component';
import { MessageService } from './shared/message.service';
import { RxStompService } from './rx-stomp/rx-stomp.service';
import { rxStompServiceFactory } from './rx-stomp/rx-stomp-service-factory';
import { ChatroomComponent } from './chat/chatroom/chatroom.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MaterialModule } from './libraries/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PrimengModule } from './libraries/primeng.module';
import { LoginMainComponent } from './auth/login-main/login-main.component';
import { NavbarComponent } from './main/navbar/navbar.component';
import { TripSummaryComponent } from './main/home/trip-summary/trip-summary.component';
import { NewTripComponent } from './main/home/new-trip/new-trip.component';
import {MatNativeDateModule} from '@angular/material/core';
import { TripMainComponent } from './main/trip-main/trip-main.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { MapComponent } from './main/trip-main/map/map.component';
import { ItineraryComponent } from './main/trip-main/itinerary/itinerary.component';
import { LodgingComponent } from './main/trip-main/lodging/lodging.component';
import { FlightComponent } from './main/trip-main/flight/flight.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    RegisterComponent,
    LogoutComponent,
    ChatroomComponent,
    LoginMainComponent,
    NavbarComponent,
    TripSummaryComponent,
    NewTripComponent,
    TripMainComponent,
    MapComponent,
    ItineraryComponent,
    LodgingComponent,
    FlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    GoogleMapsModule,
    BrowserAnimationsModule,
    MaterialModule,
    PrimengModule,
    MatNativeDateModule,
  ],
  providers: [
    MessageService,
    {
      provide: RxStompService,
      useFactory: rxStompServiceFactory
    },
    provideAnimationsAsync()
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
