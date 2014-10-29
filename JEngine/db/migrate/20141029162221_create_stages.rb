class CreateStages < ActiveRecord::Migration
  def change
    create_table :stages do |t|
      t.string :user_id
      t.string :enabled
      t.string :completed

      t.timestamps
    end
  end
end
