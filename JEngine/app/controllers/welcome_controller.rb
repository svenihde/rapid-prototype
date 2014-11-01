class WelcomeController < ApplicationController
  def index
	if cookies[:cookie_id] 
		show_cookies	
	else	
		puts "user unknown - setting cookie"
		set_cookies
	end
	@activity_list = Activity.all
  end
  def set_cookies
    cookies[:cookie_id] = rand(999999) 
  end
  
  def show_cookies
   @cookie_id = cookies[:cookie_id]
   
   puts "cookie found id= #{cookies[:cookie_id]}"
  end
  
  def delete_cookies
    cookies.delete :cookie_id
  end
end
