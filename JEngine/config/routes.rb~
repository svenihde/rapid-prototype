Rails.application.routes.draw do
   get 'set_cookies/show_cookies'
   get 'set_cookies/delete_cookies'

   post 'task/new'  => 'task#completed'
   get 'task/done'
   get 'task/process_finished'
   get 'task/process_overview'

   post 'activity/new'  => 'activity#create'
   get 'activity/done'


   resources :overview
   resources :task	
   resources :activity

   root 'welcome#index'
end
