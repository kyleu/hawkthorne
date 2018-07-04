/* Generated File */
package models.data.series

import enumeratum.values.{StringEnum, StringEnumEntry}
import java.time.LocalDate

sealed abstract class Episode(
    override val value: String, val season: Int, val episodeNum: Int, val name: String, val aired: LocalDate, val summary: String
) extends StringEnumEntry

object Episode extends StringEnum[Episode] {
  case object S00E01 extends Episode(
    value = "S00E01", season = 0, episodeNum = 1, name = "Save Greendale", aired = LocalDate.parse("2011-07-12"),
    summary = "The cast of NBC's Community address their involuntary hiatus with a hilarious, raccoon-free College Humor commercial for Greendale."
  )
  case object S00E02 extends Episode(
    value = "S00E02", season = 0, episodeNum = 2, name = "Spanish Video (1)", aired = LocalDate.parse("2010-05-03"),
    summary = "NBC webisode. Abed and Starburns present their video assignment to the Spanish class."
  )
  case object S00E03 extends Episode(
    value = "S00E03", season = 0, episodeNum = 3, name = "Spanish Video (2)", aired = LocalDate.parse("2010-05-03"),
    summary = "NBC webisode. After a second chance and a new executive producer attached, Abed and Starburns present their video assignment to the Spanish class... again."
  )
  case object S00E04 extends Episode(
    value = "S00E04", season = 0, episodeNum = 4, name = "Study Break (1)", aired = LocalDate.parse("2009-09-17"),
    summary = "Xfinity TV mini episode."
  )
  case object S00E05 extends Episode(
    value = "S00E05", season = 0, episodeNum = 5, name = "Study Break (2)", aired = LocalDate.parse("2009-09-17"),
    summary = "Xfinity TV mini episode."
  )
  case object S00E06 extends Episode(
    value = "S00E06", season = 0, episodeNum = 6, name = "Study Break (3)", aired = LocalDate.parse("2009-09-17"),
    summary = "Xfinity TV mini episode."
  )
  case object S00E07 extends Episode(
    value = "S00E07", season = 0, episodeNum = 7, name = "Dean Pelton's Office Hours -  Pamphlet Serious", aired = LocalDate.parse("2010-04-11"),
    summary = "NBC webisode. Dean Pelton mediates an exchange between the Human Being and a GCC cheerleader."
  )
  case object S00E08 extends Episode(
    value = "S00E08", season = 0, episodeNum = 8, name = "Dean Pelton's Office Hours -  Hair Piece", aired = LocalDate.parse("2010-04-11"),
    summary = "NBC webisode. Dean Pelton seeks Leonard's advice."
  )
  case object S00E09 extends Episode(
    value = "S00E09", season = 0, episodeNum = 9, name = "Dean Pelton's Office Hours -  Independant Study Assistant", aired = LocalDate.parse("2010-04-11"),
    summary = "NBC webisode. Dean Pelton's consoles his assistant after a misunderstanding."
  )
  case object S00E10 extends Episode(
    value = "S00E10", season = 0, episodeNum = 10, name = "Abed's Master Key (1)", aired = LocalDate.parse("2012-03-07"),
    summary = "NBC animated webisode. Dean Pelton hires Abed as his temporary assistant, entrusting him with the Greendale master key."
  )
  case object S00E11 extends Episode(
    value = "S00E11", season = 0, episodeNum = 11, name = "Abed's Master Key (2)", aired = LocalDate.parse("2012-03-07"),
    summary = "NBC Animated Webisode. The power of the key may be too much for Abed to handle!"
  )
  case object S00E12 extends Episode(
    value = "S00E12", season = 0, episodeNum = 12, name = "Abed's Master Key (3)", aired = LocalDate.parse("2012-03-07"),
    summary = "NBC Animated Webisode. Can Britta handle the power of the key?"
  )
  case object S01E01 extends Episode(
    value = "S01E01", season = 1, episodeNum = 1, name = "Pilot", aired = LocalDate.parse("2009-09-17"),
    summary = "Fast-talking lawyer Jeff Winger enrolls at Greendale Community College after the State Bar discovered his illegitimate degree and threatened to suspend his license, and forms a study group of unlikely friends."
  )
  case object S01E02 extends Episode(
    value = "S01E02", season = 1, episodeNum = 2, name = "Spanish 101", aired = LocalDate.parse("2009-09-24"),
    summary = "Jeff's attempt to become Britta's Spanish project partner fails and he ends up with Pierce. Shirley and Annie help Britta with a social justice cause. "
  )
  case object S01E03 extends Episode(
    value = "S01E03", season = 1, episodeNum = 3, name = "Introduction to Film", aired = LocalDate.parse("2009-10-01"),
    summary = "Jeff joins Professor Whitman class for an easy A grade but then realizes how much work he needs to put in to pass. Britta helps Abed fulfill his dream."
  )
  case object S01E04 extends Episode(
    value = "S01E04", season = 1, episodeNum = 4, name = "Social Psychology", aired = LocalDate.parse("2009-10-08"),
    summary = "Annie recruits Abed and Troy as psychology test subjects. Shirley and Jeff bond as they gossip about Britta and her boyfriend."
  )
  case object S01E05 extends Episode(
    value = "S01E05", season = 1, episodeNum = 5, name = "Advanced Criminal Law", aired = LocalDate.parse("2009-10-15"),
    summary = "Senor Chang threatens to fail the whole class unless a cheater owns up; Jeff defends the one who comes forward. Annie and Pierce team up to compose a new school song. "
  )
  case object S01E06 extends Episode(
    value = "S01E06", season = 1, episodeNum = 6, name = "Football, Feminism and You", aired = LocalDate.parse("2009-10-22"),
    summary = "While Jeff urges Troy to sign up with the football team, Britta learns girl talk etiquette from Shirley. "
  )
  case object S01E07 extends Episode(
    value = "S01E07", season = 1, episodeNum = 7, name = "Introduction to Statistics", aired = LocalDate.parse("2009-10-29"),
    summary = "Jeff must come to a decision after he makes a date with a hot statistics professor which clashes with Annie's Day of the Dead Halloween party."
  )
  case object S01E08 extends Episode(
    value = "S01E08", season = 1, episodeNum = 8, name = "Home Economics", aired = LocalDate.parse("2009-11-05"),
    summary = "Jeff's schoolmates come to his aid when they learn he is living out of his car. Pierce joins Vaughn's band while Annie and Troy plan out his date with another girl."
  )
  case object S01E09 extends Episode(
    value = "S01E09", season = 1, episodeNum = 9, name = "Debate 109", aired = LocalDate.parse("2009-11-12"),
    summary = "Jeff and Annie team up against City College for the debate championship. Pierce uses hypnotherapy on Britta to help her quit smoking. Shirley is weirded out as Abed's films appear to predict the future."
  )
  case object S01E10 extends Episode(
    value = "S01E10", season = 1, episodeNum = 10, name = "Environmental Science", aired = LocalDate.parse("2009-11-19"),
    summary = "Jeff is tasked with telling Senor Chang that he assigns an unreasonable amount of homework. Troy and Abed lose their subject for a biology lab experiment."
  )
  case object S01E11 extends Episode(
    value = "S01E11", season = 1, episodeNum = 11, name = "The Politics of Human Sexuality", aired = LocalDate.parse("2009-12-03"),
    summary = "Britta dares Jeff to find himself a partner for a double date with Pierce and his new girlfriend. Shirley and Britta help Annie to learn anatomy for a special health fair presentation in school."
  )
  case object S01E12 extends Episode(
    value = "S01E12", season = 1, episodeNum = 12, name = "Comparative Religion", aired = LocalDate.parse("2009-12-10"),
    summary = "Shirley does the preparations for an upcoming holiday party. Jeff goes up against a school bully after being challenged to a fight.   "
  )
  case object S01E13 extends Episode(
    value = "S01E13", season = 1, episodeNum = 13, name = "Investigative Journalism", aired = LocalDate.parse("2010-01-14"),
    summary = "While Jeff takes on the role of Greendale Gazette Journal's editor, the gang must decide whether or not to admit an eager classmate into their study group."
  )
  case object S01E14 extends Episode(
    value = "S01E14", season = 1, episodeNum = 14, name = "Interpretive Dance", aired = LocalDate.parse("2010-01-21"),
    summary = "Jeff struggles to keep his affair a secret. Troy and Britta choose to reveal their secret to their friends."
  )
  case object S01E15 extends Episode(
    value = "S01E15", season = 1, episodeNum = 15, name = "Romantic Expressionism", aired = LocalDate.parse("2010-02-04"),
    summary = "Jeff and Britta meddle in Annie's love life when she starts dating Britta's ex, Vaughn. Pierce feels left out of Troy and Abed's movie night."
  )
  case object S01E16 extends Episode(
    value = "S01E16", season = 1, episodeNum = 16, name = "Communication Studies", aired = LocalDate.parse("2010-02-11"),
    summary = "Jeff attempts to reconcile his friendship with Britta after he makes a terrible mistake. Shirley and Annie want to pull a prank on Señor Chang."
  )
  case object S01E17 extends Episode(
    value = "S01E17", season = 1, episodeNum = 17, name = "Physical Education", aired = LocalDate.parse("2010-03-04"),
    summary = "Jeff shows a little leg in billiards class when he's forced to wear the Greendale PE uniform, while the gang tries to help Abed get a girl."
  )
  case object S01E18 extends Episode(
    value = "S01E18", season = 1, episodeNum = 18, name = "Basic Genealogy", aired = LocalDate.parse("2010-03-11"),
    summary = "It's family day at Greendale Community College and the gang's families come to campus to join in on the fun."
  )
  case object S01E19 extends Episode(
    value = "S01E19", season = 1, episodeNum = 19, name = "Beginner Pottery", aired = LocalDate.parse("2010-03-18"),
    summary = "While Jeff takes interest in a pottery class, Pierce invites his friends to his boating class."
  )
  case object S01E20 extends Episode(
    value = "S01E20", season = 1, episodeNum = 20, name = "The Science of Illusion", aired = LocalDate.parse("2010-03-25"),
    summary = "Pierce strives to reach a new level of ascension in his Buddhist church. Britta secretly tries to shake her reputation as a buzzkill, resulting in a prank that goes horribly wrong."
  )
  case object S01E21 extends Episode(
    value = "S01E21", season = 1, episodeNum = 21, name = "Contemporary American Poultry", aired = LocalDate.parse("2010-04-22"),
    summary = "The group becomes popular when they start a racket in chicken fingers.Their new-found popularity inflates their egos, and Jeff realizes that he must find a way to end his friends' reign. "
  )
  case object S01E22 extends Episode(
    value = "S01E22", season = 1, episodeNum = 22, name = "The Art of Discourse", aired = LocalDate.parse("2010-04-29"),
    summary = "The group is divided after Pierce crosses a line with Shirley; Britta and Jeff face a group of young bullies and their mother."
  )
  case object S01E23 extends Episode(
    value = "S01E23", season = 1, episodeNum = 23, name = "Modern Warfare", aired = LocalDate.parse("2010-05-06"),
    summary = "The sexual tension between Jeff and Britta becomes a hot topic in study group. A contest for a chance at early class registration turns the peaceful campus of Greendale Community College into an all-out war zone."
  )
  case object S01E24 extends Episode(
    value = "S01E24", season = 1, episodeNum = 24, name = "English as a Second Language", aired = LocalDate.parse("2010-05-13"),
    summary = "Greendale Community College is forced to bring in a new Spanish teacher after a shocking discovery about Señor Chang. Troy discovers a trade he truly excels in -- plumbing. "
  )
  case object S01E25 extends Episode(
    value = "S01E25", season = 1, episodeNum = 25, name = "Pascal's Triangle Revisited", aired = LocalDate.parse("2010-05-20"),
    summary = "Britta and professor Slater fight for Jeff's affection; Troy is upset when Abed doesn't ask him to move into his dorm room."
  )
  case object S02E01 extends Episode(
    value = "S02E01", season = 2, episodeNum = 1, name = "Anthropology 101", aired = LocalDate.parse("2010-09-23"),
    summary = "As the new semester begins, the study group gathers to tackle Anthropology 101; Jeff struggles to establish decorum with Britta and Annie; Señor Chang decides to enroll as a student so he can join the study group."
  )
  case object S02E02 extends Episode(
    value = "S02E02", season = 2, episodeNum = 2, name = "Accounting for Lawyers", aired = LocalDate.parse("2010-09-30"),
    summary = "Jeff falls into old habits after reconnecting with Alan (Rob Corddry), a former law firm colleague; Abed, Annie and Troy look for dirt on Alan."
  )
  case object S02E03 extends Episode(
    value = "S02E03", season = 2, episodeNum = 3, name = "The Psychology of Letting Go", aired = LocalDate.parse("2010-10-07"),
    summary = "When Pierce's mother dies, the group helps to comfort him. After putting Jeff in the hospital, by one of her class pranks going awry, Professor Bauer takes a leave of absence and Professor Duncan attempts to take over her Anthropology class."
  )
  case object S02E04 extends Episode(
    value = "S02E04", season = 2, episodeNum = 4, name = "Basic Rocket Science", aired = LocalDate.parse("2010-10-14"),
    summary = "Dean Pelton asks the study group to clean and refurbish the Greendale flight simulator. After an accidental launch, Abed must navigate a safe return."
  )
  case object S02E05 extends Episode(
    value = "S02E05", season = 2, episodeNum = 5, name = "Messianic Myths and Ancient Peoples", aired = LocalDate.parse("2010-10-21"),
    summary = "Shirley asks for Abed's creative input for a religious film; Pierce is recruited by a group of students his age."
  )
  case object S02E06 extends Episode(
    value = "S02E06", season = 2, episodeNum = 6, name = "Epidemiology", aired = LocalDate.parse("2010-10-28"),
    summary = "Pierce and a few other Greendale students ingest a biohazard substance at the school Halloween Party, causing them to exhibit flu-like symptoms and begin turning into zombies. It is up to the rest of the gang to save themselves and the school when Dean Pelton locks them in with the zombie-infected student body."
  )
  case object S02E07 extends Episode(
    value = "S02E07", season = 2, episodeNum = 7, name = "Aerodynamics of Gender", aired = LocalDate.parse("2010-11-04"),
    summary = "After a classroom smackdown with a group of \"mean girls\" led by Meghan, Britta, Shirley, and Annie bond with Abed by turning him into the ultimate \"mean girl.\" Meanwhile, Jeff and Troy embrace a zen-like spirituality under the guidance of a groundskeeper when they come across a secret trampoline on campus. Determined to uncover the source of their new bliss, Pierce ends up taking a disastrous turn on the trampoline and lands in the hospital."
  )
  case object S02E08 extends Episode(
    value = "S02E08", season = 2, episodeNum = 8, name = "Cooperative Calligraphy", aired = LocalDate.parse("2010-11-11"),
    summary = "Annie's favorite pen goes missing, and she suspects that someone in the group took it. Then study room is put on lock down, and Jeff starts conducting the investigation. Troy and Abed are especially anxious to get out of the room in order to make it to the Greendale Puppy Parade in time."
  )
  case object S02E09 extends Episode(
    value = "S02E09", season = 2, episodeNum = 9, name = "Conspiracy Theories and Interior Design", aired = LocalDate.parse("2010-11-18"),
    summary = "When Dean Pelton starts checking class schedules, he discovers that Jeff has listed a class that doesn't exist. Abed and Troy build an elaborate blanket fort."
  )
  case object S02E10 extends Episode(
    value = "S02E10", season = 2, episodeNum = 10, name = "Mixology Certification", aired = LocalDate.parse("2010-12-02"),
    summary = "It is Troy's 21st birthday, so the group decides to hit the bars. While Britta and Jeff are drinking too many cocktails, Shirley is taking down incriminating pictures of herself, Annie is embracing her fake identity and Abed gets into a deep conversation with another Sci-Fi lover."
  )
  case object S02E11 extends Episode(
    value = "S02E11", season = 2, episodeNum = 11, name = "Abed's Uncontrollable Christmas", aired = LocalDate.parse("2010-12-09"),
    summary = "Abed wakes up in stop-motion animation making him believe that the group must re-discover the true meaning of Christmas. With the help of Professor Duncan, the group explores Abed's winter wonderland and soon discovers the truth behind Abed's madness."
  )
  case object S02E12 extends Episode(
    value = "S02E12", season = 2, episodeNum = 12, name = "Asian Population Studies", aired = LocalDate.parse("2011-01-20"),
    summary = "The group members debate whether to add Annie’s crush, who recently enrolled at Greendale, or Senor Chang to the group. Shirley’s ex-husband comes back into the picture, and she has big news for everyone."
  )
  case object S02E13 extends Episode(
    value = "S02E13", season = 2, episodeNum = 13, name = "Celebrity Pharmacology", aired = LocalDate.parse("2011-01-27"),
    summary = "Annie convinces the group to put on a middle school anti-drug production, but finds it continually derailed by Pierce's efforts to give himself a better role. Meanwhile, Chang attempts to connect with Shirley, while a prank involving Britta's phone puts Jeff in an awkward situation."
  )
  case object S02E14 extends Episode(
    value = "S02E14", season = 2, episodeNum = 14, name = "Advanced Dungeons & Dragons", aired = LocalDate.parse("2011-02-03"),
    summary = "Abed invites \"Fat Neil\" to play a game of Dungeons & Dragons with the rest of the study group, hoping to boost his confidence, after Jeff becomes concerned about him being a loner. When Pierce finds out he was not invited, he joins anyway, disrupting their plans."
  )
  case object S02E15 extends Episode(
    value = "S02E15", season = 2, episodeNum = 15, name = "Early 21st Century Romanticism", aired = LocalDate.parse("2011-02-10"),
    summary = "Troy and Abed compete for the attentions of the college librarian, while Britta strives to be progressive and befriends a fellow female student whom she believes is gay. Meanwhile, Jeff finds himself reluctantly hosting an impromptu party at his apartment when Professor Duncan invites himself over to watch a soccer match."
  )
  case object S02E16 extends Episode(
    value = "S02E16", season = 2, episodeNum = 16, name = "Intermediate Documentary Filmmaking", aired = LocalDate.parse("2011-02-17"),
    summary = "When Pierce lands in the hospital, he believes he's dying and gives the study group specific gifts that are actually meant to torment them. Britta wonders what to do with a blank check for \"charity,\" Jeff ponders the idea of meeting his father, and Troy gets to meet LeVar Burton, while Abed films the whole thing for a documentary."
  )
  case object S02E17 extends Episode(
    value = "S02E17", season = 2, episodeNum = 17, name = "Intro to Political Science", aired = LocalDate.parse("2011-02-24"),
    summary = "Greendale prepares for the Vice President's visit. Dean Pelton organizes the first student elections, putting Annie against Jeff, Pierce, Leonard, and Star-Burns, among others. Meanwhile, Abed develops a friendship with special agent Robin Vohlers."
  )
  case object S02E18 extends Episode(
    value = "S02E18", season = 2, episodeNum = 18, name = "Custody Law and Eastern European Diplomacy", aired = LocalDate.parse("2011-03-17"),
    summary = "Annie organizes a baby shower for Shirley, while Shirley plots to keep Senor Chang out of her life. Meanwhile, Britta is interested in Abed and Troy's new friend, Lukka, who has a dark past."
  )
  case object S02E19 extends Episode(
    value = "S02E19", season = 2, episodeNum = 19, name = "Critical Film Studies", aired = LocalDate.parse("2011-03-24"),
    summary = "Jeff incorporates Abed's love of cinema and pop culture, into a specially themed \"Pulp Fiction\" surprise birthday for him. But the tables are turned as Abed arranges another dinner with an unsuspecting Jeff at another eating establishment."
  )
  case object S02E20 extends Episode(
    value = "S02E20", season = 2, episodeNum = 20, name = "Competitive Wine Tasting", aired = LocalDate.parse("2011-04-14"),
    summary = "The study group chooses their spring electives. Britta and Troy explore an acting class, and Abed picks a course that studies the 1980s sitcom Who's the Boss?. Meanwhile, Jeff and Pierce take a wine tasting class where they meet a mysterious woman who sweeps Pierce off his feet which raises Jeff's suspicions."
  )
  case object S02E21 extends Episode(
    value = "S02E21", season = 2, episodeNum = 21, name = "Paradigms of Human Memory", aired = LocalDate.parse("2011-04-21"),
    summary = "As the study group assemble their 20th and final diorama for their anthropology class, they reminisce about their favorite moments over the past year. Meanwhile, Troy's monkey reappears but disappears back into the ventilation system, leading Senor Chang to try to get the monkey and retrieve all their stolen loot."
  )
  case object S02E22 extends Episode(
    value = "S02E22", season = 2, episodeNum = 22, name = "Applied Anthropology and Culinary Arts", aired = LocalDate.parse("2011-04-28"),
    summary = "Just as the study group are getting ready for their final Anthropology exam, Shirley goes into labor leaving the group to figure out the best way to help. Meanwhile, a riot in the parking lot starts during the World Food Festival."
  )
  case object S02E23 extends Episode(
    value = "S02E23", season = 2, episodeNum = 23, name = "A Fistful of Paintballs (1)", aired = LocalDate.parse("2011-05-05"),
    summary = "As the Greendale student body enjoys their year-end picnic, Dean Pelton announces plans for a small, quick, safe game of paintball. As the game heats up, alliances are formed - and broken - and friendships are put to the test. When a mysterious and threatening figure emerges on the Greendale campus, it becomes apparent that this is no ordinary game of paintball."
  )
  case object S02E24 extends Episode(
    value = "S02E24", season = 2, episodeNum = 24, name = "For a Few Paintballs More (2)", aired = LocalDate.parse("2011-05-12"),
    summary = "As the Greendale year-end paintball extravaganza continues, the game takes a dramatic turn with new intruders arriving on the scene. The study group realizes they must unite to defeat the enemy despite disagreements about strategy."
  )
  case object S03E01 extends Episode(
    value = "S03E01", season = 3, episodeNum = 1, name = "Biology 101", aired = LocalDate.parse("2011-09-22"),
    summary = "The Greendale study group reunites. Jeff butts heads with the new biology teacher and Dean Pelton finds a new nemesis in the dean of the Air Conditioning Repair Annex. "
  )
  case object S03E02 extends Episode(
    value = "S03E02", season = 3, episodeNum = 2, name = "Geography of Global Conflict", aired = LocalDate.parse("2011-09-29"),
    summary = "Chang gets used to his new job. Britta reacts to a friend being taken hostage in a foreign country. Annie asks the group to help bring down her new friend. Professor Cligoris struggles to behave appropriately."
  )
  case object S03E03 extends Episode(
    value = "S03E03", season = 3, episodeNum = 3, name = "Competitive Ecology", aired = LocalDate.parse("2011-10-06"),
    summary = "When the gang accepts a new person into the group, they learn how delicate their friendships really are."
  )
  case object S03E04 extends Episode(
    value = "S03E04", season = 3, episodeNum = 4, name = "Remedial Chaos Theory", aired = LocalDate.parse("2011-10-13"),
    summary = "New roommates Troy and Abed host an apartment-warming party that takes a strange turn."
  )
  case object S03E05 extends Episode(
    value = "S03E05", season = 3, episodeNum = 5, name = "Horror Fiction in Seven Spooky Steps", aired = LocalDate.parse("2011-10-27"),
    summary = "The gang tells scary stories while Britta discovers that one of her pals might be a psychopathic maniac."
  )
  case object S03E06 extends Episode(
    value = "S03E06", season = 3, episodeNum = 6, name = "Advanced Gay", aired = LocalDate.parse("2011-11-03"),
    summary = "Pierce is excited about a party he's throwing to celebrate his business success, but the affair becomes very different when his elderly father arrives."
  )
  case object S03E07 extends Episode(
    value = "S03E07", season = 3, episodeNum = 7, name = "Studies in Modern Movement", aired = LocalDate.parse("2011-11-10"),
    summary = "The study group pitches in to help when Annie decides to move in with Troy and Abed, but the plan breaks down when she becomes frustrated by their fun-loving lifestyle. Elsewhere, Dean Pelton discovers Jeff at the mall and blackmails him into spending a lovely afternoon together."
  )
  case object S03E08 extends Episode(
    value = "S03E08", season = 3, episodeNum = 8, name = "Documentary Filmmaking: Redux", aired = LocalDate.parse("2011-11-17"),
    summary = "When the school board asks Dean Pelton to make a new commercial for the school, he enlists the study group to star in his production. Meanwhile, Abed films all the activities for a documentary."
  )
  case object S03E09 extends Episode(
    value = "S03E09", season = 3, episodeNum = 9, name = "Foosball and Nocturnal Vigilantism", aired = LocalDate.parse("2011-12-01"),
    summary = "Jeff and Shirley bond over foosball. After Annie breaks Abed's special edition DVD of \"The Dark Knight\", she covers it up by staging a robbery."
  )
  case object S03E10 extends Episode(
    value = "S03E10", season = 3, episodeNum = 10, name = "Regional Holiday Music", aired = LocalDate.parse("2011-12-08"),
    summary = "When the Greendale Glee Club is unexpectedly sidelined, the school's effervescent choir director Cory Radison sets about recruiting the study group members to fill in. Skeptical at first, they eventually fall under his hypnotic spell, singing and dancing their way to the annual Christmas Pageant."
  )
  case object S03E11 extends Episode(
    value = "S03E11", season = 3, episodeNum = 11, name = "Urban Matrimony and the Sandwich Arts", aired = LocalDate.parse("2012-03-15"),
    summary = "Andre proposes that he and Shirley remarry and a wedding date is set. Britta and Annie get busy planning the wedding and Jeff prepares to give a wedding speech, while Troy and Abed get ready to be \"normal\" for the occasion. Meanwhile, Pierce and Shirley pitch a sandwich shop idea to Dean Pelton for the Greendale cafeteria."
  )
  case object S03E12 extends Episode(
    value = "S03E12", season = 3, episodeNum = 12, name = "Contemporary Impressionists", aired = LocalDate.parse("2012-03-22"),
    summary = "Jeff begins experiencing extreme narcissism. The group helps Abed get rid of debt by impersonating various celebrities at a Bar Mitzvah."
  )
  case object S03E13 extends Episode(
    value = "S03E13", season = 3, episodeNum = 13, name = "Digital Exploration of Interior Design (1)", aired = LocalDate.parse("2012-03-29"),
    summary = "As the new Greendale Subway shop opens in the cafeteria, Shirley, Pierce and Britta plot to bring about its early demise. Vice Dean Laybourne makes another attempt to get Troy to join the Air Conditioning Repair Annex, while Abed and Troy find themselves at odds over their competing pillow and blanket forts."
  )
  case object S03E14 extends Episode(
    value = "S03E14", season = 3, episodeNum = 14, name = "Pillows and Blankets (2)", aired = LocalDate.parse("2012-04-05"),
    summary = "The war between Abed and Troy intensifies, prompting Jeff to try to negotiate a truce between the former best friends while the rest of the group choose sides."
  )
  case object S03E15 extends Episode(
    value = "S03E15", season = 3, episodeNum = 15, name = "Origins of Vampire Mythology", aired = LocalDate.parse("2012-04-12"),
    summary = "Annie, Troy and Abed try to help Britta avoid an old flame who has returned to town, while Jeff and Shirley set out to catch a glimpse of the mystery man. Elsewhere, Laybourne turns to Dean Pelton for help with his pursuit of Troy."
  )
  case object S03E16 extends Episode(
    value = "S03E16", season = 3, episodeNum = 16, name = "Virtual Systems Analysis", aired = LocalDate.parse("2012-04-19"),
    summary = "When a final exam is postponed, Annie talks Abed into letting her spend some time in the dreamatorium, where an innocent simulation turns into an examination of the study group."
  )
  case object S03E17 extends Episode(
    value = "S03E17", season = 3, episodeNum = 17, name = "Basic Lupine Urology", aired = LocalDate.parse("2012-04-26"),
    summary = "In a homage to Law & Order, the study group investigate a crime when someone sabotages their science experiment. When they discover the perp, Annie plans on prosecuting them to the fullest extent of Greendale's Code of Conduct."
  )
  case object S03E18 extends Episode(
    value = "S03E18", season = 3, episodeNum = 18, name = "Course Listing Unavailable", aired = LocalDate.parse("2012-05-03"),
    summary = "When a beloved classmate dies unexpectedly, Britta uses skills from psychology class to counsel the study group. Chang tries to seize more control over campus security."
  )
  case object S03E19 extends Episode(
    value = "S03E19", season = 3, episodeNum = 19, name = "Curriculum Unavailable", aired = LocalDate.parse("2012-05-10"),
    summary = "Abed becomes convinced that there is a conspiracy afoot and that Dean Pelton is an imposter. When Abed is apprehended sneaking around on campus, he is required to see a therapist, or risk being sent to jail."
  )
  case object S03E20 extends Episode(
    value = "S03E20", season = 3, episodeNum = 20, name = "Digital Estate Planning", aired = LocalDate.parse("2012-05-17"),
    summary = "Pierce is summoned to Hawthorne Enterprises to discuss his inheritance with his deceased father's former right-hand man, Gilbert Lawson. The study group goes with him for moral support and must all pitch in to play the video game of their life on Pierce's behalf for the sake of his inheritance."
  )
  case object S03E21 extends Episode(
    value = "S03E21", season = 3, episodeNum = 21, name = "The First Chang Dynasty", aired = LocalDate.parse("2012-05-17"),
    summary = "When Chang gains control of Greendale's campus, the study group forms a plot to take back the school. Troy seeks help at the Air Conditioning Repair Annex."
  )
  case object S03E22 extends Episode(
    value = "S03E22", season = 3, episodeNum = 22, name = "Introduction to Finality", aired = LocalDate.parse("2012-05-17"),
    summary = "Jeff and and his former colleague Alan battle in court as opposing counsel in Pierce and Shirley's sandwich shop case. Meanwhile, Vice Dean Laybourne makes one last ditch effort to win Troy over to his Air Conditioning Repair Annex."
  )
  case object S04E01 extends Episode(
    value = "S04E01", season = 4, episodeNum = 1, name = "History 101", aired = LocalDate.parse("2013-02-07"),
    summary = "Jeff competes to earn the group places in the over-booked 'History of Ice Cream' class, while Abed struggles with the inevitable end of their time at Greendale, causing him to enter a 'happy place' in his mind showing bizarre alternative versions of Greendale. Annie and Shirley pull pranks around the school. "
  )
  case object S04E02 extends Episode(
    value = "S04E02", season = 4, episodeNum = 2, name = "Paranormal Parentage", aired = LocalDate.parse("2013-02-14"),
    summary = "On Halloween, Pierce accidentally locks himself in his panic room, forcing the gang to search through his house to find the code that unlocks the door."
  )
  case object S04E03 extends Episode(
    value = "S04E03", season = 4, episodeNum = 3, name = "Conventions of Space and Time", aired = LocalDate.parse("2013-02-21"),
    summary = "The study group goes to the annual Inspector Spacetime Convention; Annie enjoys the luxuries of the hotel; Jeff spends time with an Inspector Spacetime fan (Tricia Helfer) in the bar."
  )
  case object S04E04 extends Episode(
    value = "S04E04", season = 4, episodeNum = 4, name = "Alternative History of the German Invasion", aired = LocalDate.parse("2013-02-28"),
    summary = "The study group starts its European history class with professor Noel Cornwallis (Malcolm McDowell); Dean Pelton is upset when Chang returns to campus."
  )
  case object S04E05 extends Episode(
    value = "S04E05", season = 4, episodeNum = 5, name = "Cooperative Escapism in Familial Relations", aired = LocalDate.parse("2013-03-07"),
    summary = "The study group goes to Shirley's house for Thanksgiving dinner; Jeff reunites with his father, who he hasn't seen since he was young."
  )
  case object S04E06 extends Episode(
    value = "S04E06", season = 4, episodeNum = 6, name = "Advanced Documentary Filmmaking", aired = LocalDate.parse("2013-03-14"),
    summary = "Dean Pelton asks the study group to help secure a grant for research into Chang's memory loss, while Abed films their efforts for a documentary."
  )
  case object S04E07 extends Episode(
    value = "S04E07", season = 4, episodeNum = 7, name = "Economics of Marine Biology", aired = LocalDate.parse("2013-03-21"),
    summary = "Jeff, Britta and Annie help Dean Pelton recruit a wealthy potential student; Abed starts a fraternity; Troy and Shirley attend a physical education class."
  )
  case object S04E08 extends Episode(
    value = "S04E08", season = 4, episodeNum = 8, name = "Herstory of Dance", aired = LocalDate.parse("2013-04-04"),
    summary = "Britta plans a Sophie B. Hawkins dance to compete with Dean Pelton's Sadie Hawkins dance."
  )
  case object S04E09 extends Episode(
    value = "S04E09", season = 4, episodeNum = 9, name = "Intro to Felt Surrogacy", aired = LocalDate.parse("2013-04-11"),
    summary = "When the study group's balloon ride crashes in the wilderness, the friends encounter a mountain man."
  )
  case object S04E10 extends Episode(
    value = "S04E10", season = 4, episodeNum = 10, name = "Intro to Knots", aired = LocalDate.parse("2013-04-18"),
    summary = "Annie invites Professor Cornwallis to Jeff's holiday party in the hope of getting on his good side; when the friends learn Cornwallis intends to give them a bad grade, they decide to take decisive action."
  )
  case object S04E11 extends Episode(
    value = "S04E11", season = 4, episodeNum = 11, name = "Basic Human Anatomy", aired = LocalDate.parse("2013-04-25"),
    summary = "Annie and Shirley try to bring Leonard down. Troy and Abed re-enact a scene from a body switching film."
  )
  case object S04E12 extends Episode(
    value = "S04E12", season = 4, episodeNum = 12, name = "Heroic Origins", aired = LocalDate.parse("2013-05-02"),
    summary = "Convinced that the study group was destined to meet, Abed pieces together everyone's past revealing that their lives have always been intertwined. Chang tries to destroy Greendale once and for all."
  )
  case object S04E13 extends Episode(
    value = "S04E13", season = 4, episodeNum = 13, name = "Advanced Introduction to Finality", aired = LocalDate.parse("2013-05-09"),
    summary = "With enough credits to graduate, Jeff contemplates his future. The study group once again is faced with the darkest timeline."
  )
  case object S05E01 extends Episode(
    value = "S05E01", season = 5, episodeNum = 1, name = "Repilot", aired = LocalDate.parse("2014-01-02"),
    summary = "Jeff returns to Greendale to help his former law partner gather evidence for a lawsuit; thinking Jeff is planning to help save the school, Dean Pelton calls the study group back together."
  )
  case object S05E02 extends Episode(
    value = "S05E02", season = 5, episodeNum = 2, name = "Introduction to Teaching", aired = LocalDate.parse("2014-01-02"),
    summary = "Professor Hickey helps Jeff settle into his new job at Greendale; Abed convinces the study group to take a class focused on Nicolas Cage."
  )
  case object S05E03 extends Episode(
    value = "S05E03", season = 5, episodeNum = 3, name = "Basic Intergluteal Numismatics", aired = LocalDate.parse("2014-01-09"),
    summary = "Dean Pelton initiates an investigation into an anonymous bandit; Jeff is suspicious when someone makes a confession."
  )
  case object S05E04 extends Episode(
    value = "S05E04", season = 5, episodeNum = 4, name = "Cooperative Polygraphy", aired = LocalDate.parse("2014-01-16"),
    summary = "A team of investigators has the study group take lie detector tests before they can be considered for distributions from Pierce's will."
  )
  case object S05E05 extends Episode(
    value = "S05E05", season = 5, episodeNum = 5, name = "Geothermal Escapism", aired = LocalDate.parse("2014-01-23"),
    summary = "Abed plans an epic going-away party as Troy prepares to leave Greendale; a fun game transforms into a high-stakes competition."
  )
  case object S05E06 extends Episode(
    value = "S05E06", season = 5, episodeNum = 6, name = "Analysis of Cork-Based Networking", aired = LocalDate.parse("2014-01-30"),
    summary = "As Annie prepares the cafeteria for the midterm dance, she and professor Hickey must deal with the head custodian, the head of IT and the head of parking."
  )
  case object S05E07 extends Episode(
    value = "S05E07", season = 5, episodeNum = 7, name = "Bondage and Beta Male Sexuality", aired = LocalDate.parse("2014-02-27"),
    summary = "Jeff helps Duncan romance Britta; Britta runs into some old anarchist friends and discovers they've moved on; Abed accidentally destroys some of Hickey's drawings; Chang has a supernatural experience."
  )
  case object S05E08 extends Episode(
    value = "S05E08", season = 5, episodeNum = 8, name = "App Development and Condiments", aired = LocalDate.parse("2014-03-06"),
    summary = "Dean Pelton lets two designers test their new social networking application at Greendale, leading to a war among the students; Professor Hickey decides to go underground until the battle ends."
  )
  case object S05E09 extends Episode(
    value = "S05E09", season = 5, episodeNum = 9, name = "VCR Maintenance and Educational Publishing", aired = LocalDate.parse("2014-03-13"),
    summary = "Jeff, Shirley and Hickey's discovery of a hidden stash of textbooks causes power shifts within the group; Abed and Annie play a VCR game to decide who gets to choose their new roommate."
  )
  case object S05E10 extends Episode(
    value = "S05E10", season = 5, episodeNum = 10, name = "Advanced Advanced Dungeons & Dragons", aired = LocalDate.parse("2014-03-20"),
    summary = "When Professor Hickey reveals that his estranged son (David Cross) has a baby, the gang decides to help them reunite through a game of Dungeons & Dragons."
  )
  case object S05E11 extends Episode(
    value = "S05E11", season = 5, episodeNum = 11, name = "G.I. Jeff", aired = LocalDate.parse("2014-04-03"),
    summary = "The gang gets animated in the vein of \"G.I. Joe.\""
  )
  case object S05E12 extends Episode(
    value = "S05E12", season = 5, episodeNum = 12, name = "Basic Story", aired = LocalDate.parse("2014-04-10"),
    summary = "Subway makes plans to turn Greendale into Subway University; Jeff considers an employment offer; Dean Pelton tells Annie and Abed about the school's first dean."
  )
  case object S05E13 extends Episode(
    value = "S05E13", season = 5, episodeNum = 13, name = "Basic Sandwich", aired = LocalDate.parse("2014-04-17"),
    summary = "When everyone learns about Greendale's first dean, they embark on a mission to find his old computer lab; Subway enlists Chang to spy on the group as part of its plan to take over the school."
  )
  case object S06E01 extends Episode(
    value = "S06E01", season = 6, episodeNum = 1, name = "Ladders", aired = LocalDate.parse("2015-03-17"),
    summary = "Francesca “Frankie” Dart is hired as CFO of Greendale after a roof collapses from 40 years of Frisbees. Tasked with fiscal responsibility, Frankie suggests cutting unnecessary classes such as “Ladders” amongst other changes, and Abed helps Frankie. Struggling to keep Shirley’s Sandwiches afloat, Britta, Annie, Jeff and Abed turn it into a speakeasy after Frankie bans alcohol on campus."
  )
  case object S06E02 extends Episode(
    value = "S06E02", season = 6, episodeNum = 2, name = "Lawnmower Maintenance and Postnatal Care", aired = LocalDate.parse("2015-03-17"),
    summary = "The Dean purchases a VR system for Greendale that could bankrupt the school, forcing Jeff to find the creator, Elroy Patashnik, to save them. After moving in with Annie and Abed, Britta finds out her parents have been paying her debts to her friends. Chang gets bitten by a cat."
  )
  case object S06E03 extends Episode(
    value = "S06E03", season = 6, episodeNum = 3, name = "Basic Crisis Room Decorum", aired = LocalDate.parse("2015-03-24"),
    summary = "The group has to go on the offensive against a claim that Greendale graduated a dog; Abed creates an attack ad discounting the dog; Britta, after pooping her pants, connects with Elroy over the band “Natalie is Freezing;” Chang shoots a single person porn."
  )
  case object S06E04 extends Episode(
    value = "S06E04", season = 6, episodeNum = 4, name = "Queer Studies and Advanced Waxing", aired = LocalDate.parse("2015-03-31"),
    summary = "The school board invites the Dean to become a member as long as he promotes his “homosexuality.” Chang auditions for “The Karate Kid,” with Annie’s help, and endures abusive treatment from the director. Abed tries to save baby birds nesting on the Greendale Internet router with the help of Elroy."
  )
  case object S06E05 extends Episode(
    value = "S06E05", season = 6, episodeNum = 5, name = "Laws of Robotics and Party Rights", aired = LocalDate.parse("2015-04-07"),
    summary = "Jeff squares off against a charming prison inmate Willy who’s attending Greendale via telerobot. Britta enlists Abed to get around Annie’s rules against parties in their apartment. "
  )
  case object S06E06 extends Episode(
    value = "S06E06", season = 6, episodeNum = 6, name = "Basic Email Security", aired = LocalDate.parse("2015-04-14"),
    summary = "A malicious hacker threatens to publicize everyone’s personal emails unless Greendale cancels a racist comic’s performance."
  )
  case object S06E07 extends Episode(
    value = "S06E07", season = 6, episodeNum = 7, name = "Advanced Safety Features", aired = LocalDate.parse("2015-04-21"),
    summary = "A former boyfriend lures Britta into joining Honda’s guerilla marketing campaign. Jeff looks to get Elroy to like him."
  )
  case object S06E08 extends Episode(
    value = "S06E08", season = 6, episodeNum = 8, name = "Intro to Recycled Cinema", aired = LocalDate.parse("2015-04-28"),
    summary = "Chang leaves Greendale to pursue fame in Hollywood. Abed agrees to complete his unfinished film with the support of Frankie, her movie producer friend Maury and Jeff."
  )
  case object S06E09 extends Episode(
    value = "S06E09", season = 6, episodeNum = 9, name = "Grifting 101", aired = LocalDate.parse("2015-05-05"),
    summary = "When a clever clever con man, Professor DeSalvo, uses his class to cheat the study group, they enlist Jeff to get revenge. The situation goes awry as Britta and Dean Pelton get involved in Jeff and Professor DeSalvo’s scamming competition."
  )
  case object S06E10 extends Episode(
    value = "S06E10", season = 6, episodeNum = 10, name = "Basic RV Repair and Palmistry", aired = LocalDate.parse("2015-05-12"),
    summary = "During a road trip to unload one of Greendale’s useless artifacts, Abed turns a situation into a flashback-filled feature film."
  )
  case object S06E11 extends Episode(
    value = "S06E11", season = 6, episodeNum = 11, name = "Modern Espionage", aired = LocalDate.parse("2015-05-19"),
    summary = "Jeff is drawn into a secret game of paintball happening on campus and Frankie threatens to expel anyone who plays."
  )
  case object S06E12 extends Episode(
    value = "S06E12", season = 6, episodeNum = 12, name = "Wedding Videography", aired = LocalDate.parse("2015-05-26"),
    summary = "A surprise marriage proposal in Jeff’s law class reveals an unexpected connection between the bride and groom."
  )
  case object S06E13 extends Episode(
    value = "S06E13", season = 6, episodeNum = 13, name = "Emotional Consequences of Broadcast Television", aired = LocalDate.parse("2015-06-02"),
    summary = "As their sixth year at Greendale draws to a close, Abed asks everyone to imagine pitching a TV show about what they would do in season seven."
  )

  override val values = findValues
}
