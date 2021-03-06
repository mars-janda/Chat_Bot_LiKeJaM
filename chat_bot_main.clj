;;Requirements
(require '[clojure.string :as str])

;;Data Structures
(def parks_info
  {
	  :Bertramka {
		       :Food false
		       :WC true
		       :Dogs true
		       :Interest "Cultural monument, classical music concerts, social events, W. A. Mozart Museum"
		       :Bike true
		       :Rolerblades false
		       :Sport_Ground false
		       :Playground false
		       :MHD {
    				    :Tram #{4, 7, 9, 10, 58, 59}
    				    :Bus nil
    				    :Metro nil
				    }
		       :GPS "50°4’15.00’’ N, 14°23’42.00’’ E"
		       :Parking {
      					:Type "undeground"
      					:Where "OC Smichov"
					}
		       :Trail_Type "cobblestone"
		       :Owner "Městská část Praha 5 a spol. Comenius"
		       :Hours { ;;User will ask "When open", machine ask "what month" then machine gives either on or off hrs
				      :On_Season ["April", "May", "June", "July", "August", "September", "October"]
				      :Off_Season ["November", "December", "January", "February", "March"]
				      :On_Hours "9-18"
				      :Off_Hours "9:30-16"
				      }
		       :Website "https://www.praha.eu/jnp/cz/co_delat_v_praze/parky/bertramka/bertramka_text.html"
		       }

	  :Frantiskanska_zahrada {
					 :Food true
					 :WC true
					 :Dogs false
					 :Interest "Pleasant sitting in the very center of the city, suitable for children and seniors, in the vicinity of the church of P. Marie Sněžné"
					 :Bike true
					 :Rolerblades false
					 :Sport_Ground false
					 :Playground true
					 :MHD {
						      :Tram #{3, 9, 14, 24, 51, 52, 54, 55, 56, 58}
						      :Bus nil
						      :Metro #{ "A", "B"}
						      }
					 :GPS "50°4’58.8’’ N, 14°25’24.8’’ E"
					 :Parking nil
					 :Trail_Type "cobblestone, a special surface in the children's corner"
					 :Owner "Capital City of Prague"
					 :Hours { ;;User will ask "When open", machine ask "what month" then machine gives either on or off hrs
							:On_Season ["April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March"]
							:Off_Season nil
							:On_Hours "closes for the night"
							:Off_Hours nil}
					 :Website "https://www.praha.eu/jnp/cz/co_delat_v_praze/parky/frantiskanska_zahrada/frantiskanska_text.html"
					 }

	  :Obora_hvezda {
				:Food true
				:WC true
				:Dogs true
				:Interest "Suitable for families with children and tourists, memorable trees, nature trail, natural attractions"
				:Bike true
				:Rolerblades false
				:Sport_Ground false
				:Playground true
				:MHD {
					     :Tram #{15, 22, 25, 57}
					     :Bus #{179, 184, 191, 510}
					     :Metro nil
					     }
				:GPS "50°5’2.798’’ N, 14°19’45.529’’ E"
				:Parking {
						 :Type "on street"
						 :Where "at Libock Gate, or freely on U Star street"
						 }
				:Trail_Type "paved and forest"
				:Owner "National Literature Memorial and Capital City of Prague"
				:Hours { ;;User will ask "When open", machine ask "what month" then machine gives either on or off hrs
					       :On_Season ["May", "June", "July", "August", "September", "November", "December", "January", "February", "March"]
					       :Off_Season ["April", "October"]
					       :On_Hours "10-17"
					       :Off_Hours "10-18"}
				:Website "https://www.praha.eu/jnp/cz/co_delat_v_praze/parky/hvezda/obora_hvezda.html"
				}

	  :Kampa {
			 :Food true
			 :WC true
			 :Dogs true
			 :Interest "View of the Vltava River, gallery Sovovy Mlýny, Čertovka, Charles Bridge, Werich house, memorable trees"
			 :Bike true
			 :Rolerblades true
			 :Sport_Ground false
			 :Playground true
			 :MHD {
				      :Tram #{6, 9, 12, 20, 22, 23, 57, 58, 59}
				      :Bus nil
				      :Metro nil
				      }
			 :GPS "50°5’16.87’’ N, 14°24’14.58’’ E"
			 :Parking nil
			 :Trail_Type "asphalt"
			 :Owner "Prague City District 1"
			 :Hours { ;;User will ask "When open", machine ask "what month" then machine gives either on or off hrs
					:On_Season ["May", "June", "July", "August", "September", "November", "December", "January", "February", "March", "April", "October"]
					:Off_Season nil
					:On_Hours "0-0"
					:Off_Hours nil}
			 :Website "https://www.praha.eu/jnp/cz/co_delat_v_praze/parky/kampa/kampa_text.html"
			 }

	  :Kinskeho_zahrada {
				    :Food true
				    :WC true
				    :Dogs true
				    :Interest "Pleasant place to walk with children, rest zone in the middle of the city, museum, ornamental ponds, natural attraction - Petrin rock garden"
				    :Bike false
				    :Rolerblades false
				    :Sport_Ground false
				    :Playground true
				    :MHD {
						 :Tram nil
						 :Bus #{176}
						 :Metro nil
						 }
				    :GPS "50°4’44.26’’ N, 14°24’0.21’’ E"
				    :Parking {
						     :Type "undeground"
						     :Where "OC Smíchov"
						     }
				    :Trail_Type "cobblestone"
				    :Owner "Capital City of Prague"
				    :Hours { ;;User will ask "When open", machine ask "what month" then machine gives either on or off hrs
						   :On_Season ["May", "June", "July", "August", "September", "November", "December", "January", "February", "March", "April", "October"]
						   :Off_Season nil
						   :On_Hours "0-0"
						   :Off_Hours nil
						   }
				    :Website "https://www.praha.eu/jnp/cz/co_delat_v_praze/parky/kinskeho_zahrada/kinskeho_text.html"
				    }
	  }
  )
  (comment "

  (def birds_info
    {
        :Mute_Swan {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak true
                 :Mostly_White true
                 :Yellow_Beak true
                 :Yellow_Skin false
                 :Brown_Wings_And_Black_Spots false
                 :Black_And_White false
                 :Blue_And_Gray_Bill false
                 :Black_Head_White_Body false
                 :Yellow_Bill false
                }
        :Grey_Heron {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak true
                 :Mostly_White false
                 :Yellow_Beak true
                 :Yellow_Skin false
                 :Brown_Wings_And_Black_Spots false
                 :Black_And_White false
                 :Blue_And_Gray_Bill false
                 :Black_Head_White_Body false
                 :Yellow_Bill false
                }
        :Peregine_Falcon {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak false
                 :Mostly_White false
                 :Yellow_Beak true
                 :Yellow_Skin true
                 :Brown_Wings_And_Black_Spots false
                 :Black_And_White false
                 :Blue_And_Gray_Bill false
                 :Black_Head_White_Body false
                 :Yellow_Bill false
                 }
        :Kestrel {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak false
                 :Mostly_White false
                 :Yellow_Beak true
                 :Yellow_Skin false
                 :Brown_Wings_And_Black_Spots true
                 :Black_And_White false
                 :Blue_And_Gray_Bill false
                 :Black_Head_White_Body false
                 :Yellow_Bill false
                }
        :Common_Buzzard {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak false
                 :Mostly_White false
                 :Yellow_Beak true
                 :Yellow_Skin false
                 :Brown_Wings_And_Black_Spots false
                 :Black_And_White false
                 :Blue_And_Gray_Bill false
                 :Black_Head_White_Body false
                 :Yellow_Bill false
                }
        :Tuffed_Duck {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak false
                 :Mostly_White false
                 :Yellow_Beak false
                 :Yellow_Skin false
                 :Brown_Wings_And_Black_Spots false
                 :Black_And_White true
                 :Blue_And_Gray_Bill true
                 :Black_Head_White_Body false
                 :Yellow_Bill false
                }
        :Balck_Headed_Gull {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak false
                 :Mostly_White false
                 :Yellow_Beak false
                 :Yellow_Skin false
                 :Brown_Wings_And_Black_Spots false
                 :Black_And_White true
                 :Blue_And_Gray_Bill false
                 :Black_Head_White_Body true
                 :Yellow_Bill false
                 }
        :Magpie {
             :Bigger_Than_A_Cellphone true
             :Long_Orange_Beak false
             :Mostly_White false
             :Yellow_Beak false
             :Yellow_Skin false
             :Brown_Wings_And_Black_Spots false
             :Black_And_White true
             :Blue_And_Gray_Bill false
             :Black_Head_White_Body false
             :Yellow_Bill false
            }
        :Malard_Duck {
                 :Bigger_Than_A_Cellphone true
                 :Long_Orange_Beak false
                 :Mostly_White false
                 :Yellow_Beak false
                 :Yellow_Skin false
                 :Brown_Wings_And_Black_Spots false
                 :Black_And_White false
                 :Blue_And_Gray_Bill false
                 :Black_Head_White_Body false
                 :Yellow_Bill true
                }
        :Pigeon {
             :Bigger_Than_A_Cellphone true
             :Long_Orange_Beak false
             :Mostly_White false
             :Yellow_Beak false
             :Yellow_Skin false
             :Brown_Wings_And_Black_Spots false
             :Black_And_White false
             :Blue_And_Gray_Bill false
             :Black_Head_White_Body false
             :Yellow_Bill false
        :Kingfisher {
             :Bigger_Than_A_Cellphone false
             :Blue_Colour true
             :Beak_Is_Long_And_Pointy true
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :Blue_Tit {
             :Bigger_Than_A_Cellphone false
             :Blue_Colour true
             :Beak_Is_Long_And_Pointy false
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
            }
        :Black_Bird {
             :Bigger_Than_A_Cellphone true
             :Blue_Colour false
             :Beak_Is_Long_And_Pointy false
             :Black_Colour true
             :Orange_Beak true
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Brown_Colouring false
             :Parts_Of_Yellow_Green_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :Starling {
             :Bigger_Than_A_Cellphone false
             :Blue_Colour false
             :Beak_Is_Long_And_Pointy false
             :Black_Colour true
             :Orange_Beak false
             :Glossy_Coat true
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
            }
        :Jackdaw {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour false
             :Black_Colour true
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :Green_Woodpecker {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird true
             :Parts_Of_Yellow_Green_Colouring true
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :Great_Spotted_Woodpecker {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour false
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird true
             :Parts_Of_Yellow-_Green_Colouring false
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :Long_Tailed_Tit {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour false
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring true
             :Long_Black_tail true 
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :House_Sparrow {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour false 
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring true
             :Long_Black_tail false
             :White_Plumage_On_Breasts true
             :Yellow_Plumage_On_Breasts false
             }
        :Wren {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour false
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring true
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :Great_Tit {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour false
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts false
             }
        :Nuthatch {
             :Bigger_Than_A_Cellphone false
             :Beak_Is_Long_And_Pointy false
             :Blue_Colour false
             :Black_Colour false
             :Orange_Beak false
             :Glossy_Coat false
             :Red_Colouring_On_Bird false
             :Parts_Of_Yellow_Green_Colouring false
             :Parts_Of_Brown_Colouring false
             :Long_Black_tail false
             :White_Plumage_On_Breasts false
             :Yellow_Plumage_On_Breasts true
             }
    })
  ")
;;Responses

(def responses ;;for multiple dp items (parking, MHD, hours) create a vector that allows for the process_input
               ;;function to insert the datapoints in between the strings. (see :parking_yes for eg.)
  {
    :food_yes {
      :1 "Yes, there are food vendors at this park."
      :2 "Yes, food is available there."
    }
    :food_no {
      :1 "No, you cannot eat at this park."
    }
    :parking_yes {
      :1 ["Yes there is ", "parking", "available at", "."]
      :2 ["Sure! ", "parking", "is available at", "."]
    }
    :parking_no {
      :1 "There is no information on parking for this park."
      :2 "No there is not parking."
	}
    :wc_yes {
      :1 "Yes there is a public WC at this park."
      :2 "Yes, wc is available there."
    }
    :wc_no {
      :1 "Unfortunately, there is no WC at this park."
      :2 "There is not any WC at this park."
	}
    :dog_yes {
      :1 "Yes, you can walk your dog here."
      :2 "Yes, walking the dog is allowed here."
	}
    :dog_no {
      :1 "No, you cannot walk your dog here."
      :2 "Sadly, you are not allowed to walk dogs at this park."
	}
	:bike_yes {
	  :1 "You can ride a bike in this park."
	  :2 "Riding a bike is allowed here."
	}
	:bike_no {
	  :1 "No, you can't ride a bike in this park."
	  :2 "Riding a bike in this park is not allowed."
	}
    :rolerblades_yes {
      :1 "Yes, riding rolerblades is allowed there."
    }
    :rolerblades_no {
      :1 "No, you cannot ride rolerblades at this park."
      :2 "There are not any food vendors there."
    }
	:sport_ground_yes {
	  :1 "Yes, there is a sports ground there."
	  :2 "A sports ground is located at this park."
	}
	:sport_ground_no {
      :1 "No, there is not a sports ground at this park."
	}
	:playground_yes {
	  :1 "Yes, the park has a playground."
	  :2 "Yes, a playground is located in this park."
	}
  :playground_no {
      :1 "No, this park does not have a playground."
	}
	:tram_yes {
	  :1 ["To reach this park you can take the tram number ","."]
	  :2 ["You can go to this park by taking the tram number ", "."]
	}
	:bus_yes {
	  :1 ["This park can be reached by bus number ", "."]
	  :2 ["You can get the bus number "," to go to this park."]
	}
  :metro_yes {
	  :1 ["This park can be reached by metro line ", "."]
	  :2 ["You can get the metro line "," to go to this park."]
	}
  :tram_bus_yes {
	  :1 ["You can go to this park by tram number "," or by bus ","."]
	}
	:tram_metro_yes {
	  :1 ["This park can be reached either by tram number", "or the metro line "," ."]
	}
	:bus_metro_yes {
	  :1 ["You can take the bus number ", "or the metro line ","."]
	}
	:tram_no_bus_yes {
	  :1 ["Unfortunately, you can not go to this park by tram but you can get bus number ", "."]
	}
	:tram_no_metro_yes {
	  :1 ["Unfortunately, this park cannot be reached by tram but you can take the metro line", "to get there."]
	}
	:bus_no_tram_yes {
	  :1 ["No, you cannot take the bus to get here but you can get the tram number", "to go to this park."]
	}
	:bus_no_metro_yes {
	  :1 ["No, the park is not reached by the bus but you can get the metro line", "."]
	}
	:metro_no_tram_yes {
	  :1 ["The metro doesn't get there, try taking the tram number", "to get to the park."]
	}
	:metro_no_bus_yes {
	  :1 ["There is no metro that goes there, try taking the bus number", "to reach the park"]
	}
	:tram_bus_metro_yes {
	  :1 ["This park can be reache by tram number ", ", bus number ", "or by metro line", "."]
	}
	:tram_bus_metro_no {
	  :1 "There is no public transportation to this park"
	}
	:on_hours_response {
	  :1 ["The park is open during", "."]
	}
	:on_season_response {
      :1 ["The park stays open during the months of", "."]
	}
	:off_hours_response {
	  :1 ["The park stays closed during", "."]
	}
  :off_season_response {
	  :1["The park is closed during the months of", "."]
	}
    })

;;Predicates
(defn food? [park]
  (:Food (park parks_info)))

(defn WC? [park]
  (:WC (park parks_info)))

(defn bike? [park]
  (:Bike (park parks_info)))

(defn rolerblades? [park]
  (:Rolerblades (park parks_info)))

(defn sport_ground? [park]
  (:Sport_Ground (park parks_info)))

(defn playground? [park]
  (:Playground (park parks_info)))

(defn parking? [park]
  (not (nil? (:Parking (park parks_info)))))

(defn dogs? [park]
  (:Dogs (park parks_info)))

;;Get info
(defn parking_info [park]
  (when (parking? park)
    [(:Type (:Parking (park parks_info))), (:Where (:Parking (park parks_info)))]))

(defn trail_type [park]
  (:Trail_Type (park parks_info)))

(defn gps_coordinates [park]
  (:GPS (park parks_info)))

(defn owner [park]
  (:Owner (park parks_info)))

(defn on_hours [park]
  (:On_Hours (:Hours (park parks_info))))
(defn off_hours [park]
  (:Off_Hours (:Hours (park parks_info))))

(defn on_season [park]
  (:On_Season (:Hours (park parks_info))))
(defn off_season [park]
  (:Off_Season (:Hours (park parks_info))))

(defn tram [park] (:Tram (:MHD (park parks_info))))
(defn tram_line? [park tram_no] (contains? (tram park) tram_no))

(defn bus [park] (:Bus (:MHD (park parks_info))))
(defn bus_line? [park bus_no] (contains? (bus park) bus_no))

(defn metro [park] (:Metro (:MHD (park parks_info))))
(defn metro_line? [park metro_line] (contains? (metro park) metro_line))

(defn website [park]
  (:Website (park parks_info)))

;;UIR
(defn normalize_string [string]
  (re-find #".*[A-Za-z]" (str/lower-case string)))

(defn string_to_vector [string]
  (str/split string #" "))

(defn arr_contains? [uarr search]
  (let [stop (dec (count uarr))]
    (loop [i 0]
      (let [current (nth uarr i)]
        (if (= (normalize_string current) search)
          true
          (if (< i stop)
            (recur (inc i))
            false))))))

;;This will contain the set of conditions that process_input functions will use
;;determine what question is being aske

;;sets of keyword synonyms and related words
(def set_food #{"food", "eat", "drinks", "beverages", "concessions", "restaurant", "restaurants"})
(def set_wc #{"wc", "toilet", "toilets", "bathroom", "bathrooms", "restroom", "restrooms"})
(def set_dog #{"dog", "dogs", "pet", "pets"})
(def set_interests #{"interests", "sights", "events"})
(def set_bike #{"bike", "biking", "bicycle", "bikes", "bicycles"})
(def set_rollerblades #{"rollerblade", "rollerskating", "rollerblading", "rollerskates",
                      "rollerblades"})
(def set_sportground #{"court", "field", "soccer", "sportground","basketball"})
(def set_playground #{"playground", "playset"})
(def set_mhd #{"transportation","directions" "bus", "tram", "metro", "transport", "mhd", "reach"})
(def set_gps #{"gps", "coordinates", "located"})
(def set_parking #{"parking", "cars", "car"})
(def set_trailtype #{"trail", "trails", "surface"})
(def set_owner #{"owner", "own", '("who", "runs")})
(def set_hours #{"open", "hours", "opening","close"})
(def set_website #{"site", "website", '("more", "info"), '("further", "info")
                  '("more", "information"), '("further", "information"), "link"})

;;normalize park name with cobblestone
(defn normalize_key [key]
  (re-find #"[A-Za-z].*" (str key)))
;;gr => generate reply
(defn gr_food [park]
  (def i_foo 1)
  (cond
    (food? park)
      (println (:1 (:food_yes responses)))
    (not (food? park))
      (println (:1 (:food_no responses)))))

(defn gr_wc [park]
  (def i_wc 1)
  (cond
    (WC? park)
      (println (:1 (:wc_yes responses)))
    (not (WC? park))
      (println (:1 (:wc_no responses)))))

(defn gr_dog [park]
  (def i_dog 1)
  (cond
    (dogs? park)
      (println (:1 (:dog_yes responses)))
    (not (dogs? park))
      (println (:1 (:dog_no responses)))))

(defn gr_interests [park]
  (def i_int 1)
  (println "There are" (:Interest (park parks_info))))

(defn gr_bike [park]
  (def i_bik 1)
  (cond
    (bike? park)
      (println (:1 (:bike_yes responses)))
    (not (bike? park))
      (println (:1 (:bike_no responses)))))

(defn gr_rollerblades [park]
  (def i_rol 1)
  (cond
    (rolerblades? park)
      (println (:1 (:rolerblades_yes responses)))
    (not (rolerblades? park))
      (println (:1 (:rolerblades_no responses)))))

(defn gr_sportground [park]
  (def i_spo 1)
  (cond
    (sport_ground? park)
      (println (:1 (:sport_ground_yes responses)))
    (not (sport_ground? park))
      (println (:1 (:sport_ground_no responses)))))

(defn gr_parking [park]
  (def i_par 1)
  (cond
    (parking? park)
      (println "Yes there is" (first (parking_info park)) "parking available at" (rest (parking_info park)) ".")
    (not (playground? park))
      (println (:1 (:parking_no responses)))))

(defn gr_mhd [park]
  (def i_mhd 1)
  (println "Below are the available public transportation lines for" (normalize_key park))
  (println "Tram:" (tram park))
  (println "Bus:" (bus park))
  (println "Metro:" (metro park)))

(defn gr_gps [park]
  (def i_gps 1)
  (println "The GPS coordinates for" (normalize_key park) "are" (gps_coordinates park)))

(defn gr_playground [park]
  (def i_pla 1)
  (cond
    (playground? park)
      (println (:1 (:playground_yes responses)))
    (not (playground? park))
      (println (:1 (:playground_no responses)))))

(defn gr_trailtype [park]
  (def i_tra 1)
  (println ">The surface of the trails at" (normalize_key park) "are" (trail_type park)))

(defn gr_owner [park]
  (def i_own 1)
  (println ">The owner of" (normalize_key park) "is" (owner park)))

(defn gr_hours [park]
  (def i_hou 1)
  (println "The hours during" (on_season park) "are" (on_hours park))
  (println "The off season hours during" (off_season park) "are" (off_hours park)))

(defn gr_website [park]
  (def i_web 1)
  (println ">The website for" (normalize_key park) "is" (website park)))


;;detection of park
;;remembers what park is being discussed until a new one is mentioned
(def current_topic nil)
(defn setp_bertramka [] (def current_topic :Bertramka))
(defn setp_frantiskanska [] (def current_topic :Frantiskanska_zahrada))
(defn setp_obora [] (def current_topic :Obora_hvezda))
(defn setp_kampa [] (def current_topic :Kampa))
(defn setp_kinskeho [] (def current_topic :Kinskeho_zahrada))
(defn setp_birdID [] (def current_topic "bird_id"))

;;contains the series of questions and answers needed to identify a bird
(def bird_decision_tree {
  :q "Was the bird bigger than a cellphone?"
  :yes {:q "Did it have a long orange beak?"
      :yes {:q "Was the bird mostly white?"
          :yes "Mute Swan"
          :no "Grey Heron"}
      :no {:q "Is the skin around the birds beak yellow?"
          :yes {:q "Was the skin around its eyes yellow as well?"
                :yes "Peregine Falcon"
                :no {:q "Did the bird have brown wings with black spots?"
                    :yes "Kestrel"
                    :no "Common Buzzard"}}
          :no {:q "Was the bird predominantly black and white?"
              :yes {:q "Did it have a blue-gray bill?"
                    :yes "Tufted Duck"
                    :no {:q "Did the bird have a black head with a mainly white body?"
                        :yes "Black-headed Gull"
                        :no "Magpie"}}
              :no {:q "Did the bird have a yellow bill?"
                  :yes "Malard Duck"
                  :no "Pigeon"}}}}
  :no {:q "Did the bird have blue coloring?"
      :yes {:q "Is the birds beak long and pointy?"
            :yes "Kingfisher"
            :no "Blue Tit"}
      :no {:q "Was the bird black?"
          :yes {:q "Did it have an orange beak?"
              :yes "Blackbird"
              :no {:q "Did the bird have a glossy coat?"
                  :yes "Starling"
                  :no "Jackdaw"}}
          :no {:q "Was there a red coloring on the bird?"
              :yes {:q "Did the bird have a yellow-green coloring on its wings?"
                    :yes "Green Woodpecker"
                    :no "Great-spotted Woodpecker"}
              :no {:q "Did the bird have parts of brown coloring?"
                  :yes {:q "Did it have a long black tail?"
                        :yes "Long-tailed Tit"
                        :no {:q "Did the bird have white plumage on its breast?"
                            :yes "House Sparrow"
                            :no "Wren"}}
                  :no {:q "Did the bird have yellow plumage on its breast?"
                      :no "Great Tit"
                      :yes "Nuthatch"}}}}}
  })

;;;;;;;;;;;;;;;;;;;;BIRD TAXONOMY DECISION TREE;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def position_in_tree bird_decision_tree)

;;handles the navigation of the decision tree
(defn bird_taxonomy [user_in_arr]
    (cond
      (arr_contains? user_in_arr "yes")
        (do
          (def position_in_tree (:yes position_in_tree))
          (if (= (:q position_in_tree) nil)
            (do
              (println position_in_tree)
              (println " ~('>
  / )
   4"
)
              (def current_topic nil))
            (println (:q position_in_tree))))
      (arr_contains? user_in_arr "no")
        (do
          (def position_in_tree (:no position_in_tree))
          (if (= (:q position_in_tree) nil)
            (do
              (println position_in_tree)
              (println " ~('>
  / )
   4"
)
              (def current_topic nil))
            (println (:q position_in_tree))))
        :else
          (do
            (println (:q position_in_tree))
            (println "Please reply with 'yes' or 'no' answers only"))))

(declare detect_keywords)
;;topic detection decides what park is being discussed or if a dog is being identified
(defn topic_handler [user_in_arr]
  ;;(println user_in_arr)
  (cond
    (arr_contains? user_in_arr "bertramka")
      (do
        ;;(println "DEBUG BERTRAMKA DETECTED")
        (setp_bertramka)
        (detect_keywords user_in_arr current_topic))
    (arr_contains? user_in_arr "frantiskanska")
      (do
        ;;(println "DEBUG FRANTISKANKA DETECTED")
        (setp_frantiskanska)
        (detect_keywords user_in_arr current_topic))
    (arr_contains? user_in_arr "obora")
      (do
        ;;(println "DEBUG OBORA DETECTED")
        (setp_obora)
        (detect_keywords user_in_arr current_topic))
    (arr_contains? user_in_arr "kampa")
      (do
        ;;(println "DEBUG KAMPA DETECTED")
        (setp_kampa)
        (detect_keywords user_in_arr current_topic))
    (arr_contains? user_in_arr "kinskeho")
      (do
        (setp_kinskeho)
        (detect_keywords user_in_arr current_topic))
    (arr_contains? user_in_arr "bird")
      (setp_birdID)
    :else
      (if (= current_topic nil)
        (println "Please specify a park or ask about a bird")
        (detect_keywords user_in_arr current_topic)))
  (when (= current_topic "bird_id") (bird_taxonomy user_in_arr)))

;;detection of keywords and questions being asked
(defn detect_keywords [user_in_arr park]
  ;(println "DETECT KEYWORDS RAN")
  ;;variables that prevent multiple replies being generated for 2 keywords from user
  (def i_foo 0)
  (def i_wc 0)
  (def i_dog 0)
  (def i_int 0)
  (def i_bik 0)
  (def i_rol 0)
  (def i_spo 0)
  (def i_par 0)
  (def i_mhd 0)
  (def i_gps 0)
  (def i_pla 0)
  (def i_tra 0)
  (def i_own 0)
  (def i_hou 0)
  (def i_web 0)

  (let [stop (dec (count user_in_arr))]
    (loop [i 0
          previous nil]
      (let [current (nth user_in_arr i)]
        (cond
          (and (= i_foo 0) (contains? set_food (normalize_string current)))
            (gr_food park)
          (and (= i_wc 0) (contains? set_wc (normalize_string current)))
            (gr_wc park)
          (and (= i_dog 0) (contains? set_dog (normalize_string current)))
            (gr_dog park)
          (and (= i_int 0) (contains? set_interests (normalize_string current)))
            (gr_interests park)
          (and (= i_bik 0) (contains? set_bike (normalize_string current)))
            (gr_bike park)
          (and (= i_rol 0) (contains? set_rollerblades (normalize_string current)))
            (gr_rollerblades park)
          (and (= i_spo 0) (contains? set_sportground (normalize_string current)))
            (gr_sportground park)
          (and (= i_pla 0) (contains? set_playground (normalize_string current)))
            (gr_playground park)
          (and (= i_mhd 0) (contains? set_mhd (normalize_string current)))
            (gr_mhd park)
          (and (= i_gps 0) (contains? set_gps (normalize_string current)))
            (gr_gps park)
          (and (= i_par 0) (contains? set_parking (normalize_string current)))
            (gr_parking park)
          (and (= i_tra 0) (contains? set_trailtype (normalize_string current)))
            (gr_trailtype park)
          (and (= i_own 0) (or
            (contains? set_owner (normalize_string current))
            (contains? set_owner (list previous (normalize_string current)))))
            (gr_owner park)
          (and (= i_hou 0) (contains? set_hours (normalize_string current)))
            (gr_hours park)
          (and (= i_web 0) (or
            (contains? set_website (normalize_string current))
            (contains? set_website (list previous (normalize_string current)))))
            (gr_website park)
          )
      (when (< i stop)
        (recur (inc i) (normalize_string current)))))))

;;chatbot dialogue
(defn dialogue_loop []
  (println ">Hello, I LiKe JaM. What would you like to know about the parks in Prague?")
  (println "================================================================")
  (loop [user_in (read-line)]
    (if (not (or (= user_in "exit") (= user_in "q")))
      (do
        (println "----------------------------------------------------------------")
        (topic_handler (string_to_vector user_in))
        (println "================================================================")
        (recur (read-line)))
      (do
        (println "----------------------------------------------------------------")
        (println ">Goodbye!")))))

(dialogue_loop)
