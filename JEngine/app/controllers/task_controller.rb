class TaskController < ApplicationController
  def new
	if !cookies[:cookie_id] 
		redirect_to root_path
	end

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
