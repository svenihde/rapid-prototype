Rails.application.routes.draw do
  get 'set_cookies/show_cookies'

  get 'set_cookies/delete_cookies'

   #get 'welcome/index'

   resources :overview
   resources :task	

   # You can have the root of your site routed with "root"
   root 'welcome#index'
end
