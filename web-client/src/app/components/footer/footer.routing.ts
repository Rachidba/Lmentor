import { FooterComponent } from './footer.component';

import { Routes, RouterModule } from '@angular/router'
import { ModuleWithProviders } from '@angular/core'

export const routes: Routes = [
    { path: '', component: FooterComponent }
]
  
export const routing: ModuleWithProviders = RouterModule.forChild(routes)

