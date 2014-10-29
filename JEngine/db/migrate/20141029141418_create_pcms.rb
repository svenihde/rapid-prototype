class CreatePcms < ActiveRecord::Migration
  def change
    create_table :pcms do |t|
      t.string :type
      t.string :sub_type
      t.string :description

      t.timestamps
    end
  end
end
