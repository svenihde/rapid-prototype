class TaskController < ApplicationController

  #
  #
  def new
	if !cookies[:cookie_id] 
		redirect_to root_path
	end
	
	# Runtime-knowledge: lookup process model from table for each next step (could be cached to improve performance)
	pick_next_task(find_current_process, find_last_completed_task)	

	foo = Activity.where(id: @upcoming_task).empty?
	if foo
		redirect_to :action => 'process_finished'
	else
		@next_task = Activity.where(id: @upcoming_task).first
	end	
  end

  #
  #
  def find_last_completed_task
	foo = Stages.find_by(user_id: cookies[:cookie_id]).completed.nil?
	if foo
		completed_tasks = Array.new
		completed_tasks << '1'
	else
		completed_tasks = Stages.find_by(user_id: cookies[:cookie_id]).completed	
	end
	return (completed_tasks.max)
  end 

  #
  #
  def find_current_process
	#TODO: assumption = right now we just handle one process per user, to be edited if we handle more than 1 process simutanously
	foo = Stages.find_by(user_id: cookies[:cookie_id]).processes.empty?
	if foo
		process_id = '1'	
	else
		process_id = Stages.find_by(user_id: cookies[:cookie_id]).processes
	end
	return (process_id.to_i)
  end 

  #
  #
  def pick_next_task(process_id, last_completed_task)
	sequence = Processes.find_by(id: process_id).sequence	
	modul = Processes.find_by(id: process_id).module

	#TODO: activity_id must not be identically to activity_id in process
	position = sequence[last_completed_task] 
	position = position+ 1
	#render text: sequence.inspect
	sequence.each { |key,value| set_upcoming_task(value) if value == position }
  end   

  #
  #
  def set_upcoming_task(value)
	@upcoming_task = value
  end   
  #
  #
  def process_finished
  end
  
  #
  #
  def done
  end
  
  #
  #
  def completed
      cookie_id = cookies[:cookie_id]
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
  
  #
  #
  def process_overview
	@activity_list = Activity.all
  end
  #
  #
  private
	def task_params
		params.require(:task).permit(:id, :title, :description)
	end
end
