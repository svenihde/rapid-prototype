class CreateBackgrounds < ActiveRecord::Migration
  def change
    create_table :backgrounds do |t|
      t.string :cookie
      t.string :last_task

      t.timestamps
    end
  end
end
