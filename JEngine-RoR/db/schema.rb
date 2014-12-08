# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

<<<<<<< HEAD:JEngine-RoR/db/schema.rb
ActiveRecord::Schema.define(version: 20141101125321) do
=======
ActiveRecord::Schema.define(version: 20141102001327) do
>>>>>>> version2:JEngine/db/schema.rb

  create_table "activities", force: true do |t|
    t.string   "title"
    t.text     "description"
    t.datetime "created_at"
    t.datetime "updated_at"
<<<<<<< HEAD:JEngine-RoR/db/schema.rb
  end

  create_table "backgrounds", force: true do |t|
    t.string   "cookie"
    t.string   "last_task"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "pcms", force: true do |t|
    t.string   "type"
    t.string   "sub_type"
    t.string   "description"
=======
    t.string   "kind"
    t.text     "open"
  end

  create_table "processes", force: true do |t|
    t.string   "title"
    t.text     "sequence"
    t.text     "module"
    t.text     "comments"
>>>>>>> version2:JEngine/db/schema.rb
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "stages", force: true do |t|
    t.string   "user_id"
    t.string   "enabled"
    t.string   "completed"
    t.datetime "created_at"
    t.datetime "updated_at"
<<<<<<< HEAD:JEngine-RoR/db/schema.rb
=======
    t.text     "skipped"
    t.text     "processes"
>>>>>>> version2:JEngine/db/schema.rb
  end

end
