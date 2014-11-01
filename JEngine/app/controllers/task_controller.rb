class TaskController < ApplicationController
  def new
	if !cookies[:cookie_id] 
		redirect_to root_path
	end
	foo = Stages.find_by(user_id: cookies[:cookie_id]).nil?
	if foo
		completed_tasks = Array.new
		completed_tasks << '0'
	else
		completed_tasks = Stages.find_by(user_id: cookies[:cookie_id]).completed	
	end
	last_completed_task = completed_tasks.max
	last_completed_task = last_completed_task.to_i
	upcoming_task  = last_completed_task + 1

	foo = Activity.where(id: upcoming_task).empty?
	if foo
		redirect_to :action => 'process_finished'
	else
		@next_task = Activity.where(id: upcoming_task).first
	end	
  end
  def process_finished
  end
  def done
	#puts 'done editing'
  end
  def completed
      cookie_id = cookies[:cookie_id]
      #fo = Activity.new(task_params)
      task_id = params['task']['id']

      #updates db record
      foo = Stages.find_by_user_id(cookie_id)
      if !foo
              Stages.create(user_id: cookie_id)
      end
      completed_tasks = Stages.find_by(user_id: cookie_id).completed
      if !completed_tasks
	  completed_tasks = Array.new
      end
      completed_tasks << task_id
      Stages.where(:user_id => cookie_id).update_all(:completed => completed_tasks)

      redirect_to :action => 'done'
  end
  private
	def task_params
		params.require(:task).permit(:id, :title, :description)
	end
end
