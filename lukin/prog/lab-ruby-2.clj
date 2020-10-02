(ns lukin.prog.lab-ruby-2)

(defn parse-log-string [s]
  (let [[full & other] (re-matches #"(?x)                  # SOL
      (\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})\s+                   # ip-address
      .+?\s+
      .+?\s+
      \[(\d{1,2})\/(\w+)\/(\d+):(\d+):(\d+):(\d+)\s\+(\d+)\]\s+ # datetime
      \"(\w+) (.+?) ([\w\/\.]+)\"\s+                            # method resource protocol
      (\d+)\s+                                                  # status
      .+?\s+
      \"(.*?)\"\s+                                              # host
      \"(.*?)\"\s+                                              # user-agent
      $                                                         # EOL"
      s)]
      other))

(println (parse-log-string
    "162.158.92.81 - - [30/Sep/2019:06:34:46 +0000] \"GET /version.json?t=1569825287696 HTTP/1.1\" 200 81 \"https://crm.iwu.team/admin/candidates/12992\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36\"\n"))
(println "----------------------------------------------")
(let [[
  ip
  day month year hour minute second zone
  method resource protocol
  status host user_agent
  ] (parse-log-string "162.158.92.81 - - [30/Sep/2019:06:34:46 +0000] \"GET /version.json?t=1569825287696 HTTP/1.1\" 200 81 \"https://crm.iwu.team/admin/candidates/12992\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36\"\n")]

    (println ip
      day month year hour minute second zone
      method resource protocol
      status host user_agent )
  )
