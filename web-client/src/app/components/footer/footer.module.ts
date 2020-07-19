import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';

import { FooterComponent } from './footer.component';
import { routing } from './footer.routing';


@NgModule({
  declarations: [
      FooterComponent
  ],
  imports     : [
      routing,
      MatButtonModule,
      MatIconModule,
      MatToolbarModule
  ],
  exports     : [
      FooterComponent
  ]
})
export class FooterModule
{
}
