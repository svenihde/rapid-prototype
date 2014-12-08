class CreateProcesses < ActiveRecord::Migration
  def change
    create_table :processes do |t|
      t.string :title
      t.text :sequence
      t.text :module
      t.text :comments

      t.timestamps
    end
  end
end
