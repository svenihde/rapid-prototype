class TaskController < ApplicationController
  def new
	#puts 'viewing index'
  end
  def done
	#puts 'done editing'
  end
  def completed
      cookie_id = cookies[:cookie_id]
      task_id = params[:task_id]
      task_id = task_id.keys.to_s
      #updates db record
      foo = Stages.find_by_user_id(cookie_id)
      if !foo
         foo = Stages.create(user_id: cookie_id, enabled: '', completed: '')
      end
      foo = Stages.where(:user_id => cookie_id).update_all(:completed => task_id)

      redirect_to :action => 'done'
  end
end
