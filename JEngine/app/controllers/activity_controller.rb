class ActivityController < ApplicationController
  def new
	#puts 'adding activity'
  end
  def create
	render plain: params[:activity].inspect
	foo = Activites.create(title: title, description: description)
        if !foo
	 	puts 'error during adding new activity into DB'
        end
        
        redirect_to :action => 'done'
	
	#task_id = Activity.order("update_at DESC").limit(1)
	#puts 'you added the activity with the task_id #{task_id}'
  end
  def done
  end
  def edit
	#task_id =
	#puts 'editing activity'
  end
end
