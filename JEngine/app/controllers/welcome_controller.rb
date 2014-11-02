class WelcomeController < ApplicationController
  #
  #
  def index
    	if cookies[:cookie_id] 
    		show_cookies
    	else	
    		puts "user unknown - setting cookie"
    		set_cookies	
		Stages.create(user_id: cookies[:cookie_id], processes: '1')
    	end
    	@activity_list = Activity.all
    	show_completed_activites
  end
  
  #
  #
  def set_cookies
    cookies[:cookie_id] = rand(999999) 
  end
  
  #
  #
  def show_cookies
   @cookie_id = cookies[:cookie_id] 
   #puts "cookie found id= #{cookies[:cookie_id]}"
  end
  
  #
  #
  def delete_cookies
    cookies.delete :cookie_id
  end
  
  #
  #
  def show_completed_activites
      @stages_of_cookie_id = Stages.where(user_id: cookies[:cookie_id] )
  end
end
