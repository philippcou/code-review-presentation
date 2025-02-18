---
theme: default
background: https://cover.sli.dev
title: Code Reviews
info: |
  ## Präsentation über Code Reviews
class: text-center
layout: cover
drawings:
  persist: false
transition: slide-up
# enable MDC Syntax: https://sli.dev/features/mdc
mdc: true
---

# Code Reviews

Qualitätssicherung und Zusammenarbeit im Entwicklungsteam

<div class="abs-br m-6 text-xl">
  <button @click="$slidev.nav.openInEditor" title="Open in Editor" class="slidev-icon-btn">
    <carbon:edit />
  </button>
  <a href="https://github.com/slidevjs/slidev" target="_blank" class="slidev-icon-btn">
    <carbon:logo-github />
  </a>
</div>

---
transition: slide-up
class: text-white
---
<Toc />


---
transition: slide-up
class: text-white
---
# Was ist ein Code Review?

- Strukturierte Überprüfung von Code durch andere Entwickler
- Möglichkeit zu lernen & Wissen zu vertiefen
- Checklist
  - Macht der Code, was er soll?
  - Ist der Code verständlich & gut dokumentiert?
  - Passt der Code zum Team-Standard?
  - Sind Klassen, Methoden, Variablen etc. sinnvoll benannt?
  - Förderung des Teamzusammenhalts (Geteilte 

<!--
Verantwortung)
-->

---
transition: slide-up
class: text-white
---

# Code Review Best Practices

- Regelmäßige Reviews
- Konstruktives Feedback
- Subjektives Feedback als solches deklarieren
- Einsatz von automatisierten Tools

<!--
Üblicherweise bei jedem PR

Feedback positiv gestalten, verbesserungsvorschläge mitgeben

Subjektives Feedback "Nitpicks" als solche definieren

Einsatz von automatisierten tools als vorarbeit
-->

---
transition: slide-up
class: text-white
---

# Pull Request Best Practices

- Branch Name
- Commit Messages
- PRs möglichst klein halten
- Standatisierte Formatierung !!!!!!!!
- Sinnvolle Description im PR
  - Zusammenfassung der Changes
  - Grund des PRs

<!--
Branch Name und Commit Messages mit einem Ticket verlinkt, oder sehr aussagekräftiger Titel

Description vom Pull Request
-->


---
transition: slide-up
class: text-white
---

# Automatisierte Tools

- Verwendung
  - Sicherheitslücken
  - Code Qualität
  - Testabdeckung
- Einsatz im BRZ: Quality Gates

<!--
TODO Zeigen von Quality Gate tabelle vom BRZ
-->

<!--
Vorteile: Erzeugen ein Minimum an Code Qualität, Entlastung der Entwickler, Kleinigkeiten werden of abgefangen, die häufigsten Sicherheitslücken werden erkannt
Nachteile: Verlängerung des Build Prozesses, Entwickler können sich genervt fühlen 
-->

---
transition: slide-up
class: text-white
---

# Sonarqube

- Statische Code Analyse (Programmiersprachen-spezifische Regeln)
- Testabdeckung
- OWASP Checks



---
transition: slide-up
class: text-white
---

# Persönliche Erfahrungen

- <span style="color: #f57f85;">Entwickler nehmen sich nicht die Zeit</span>
- <span style="color: #f57f85;">Kleinigkeiten werden kommentiert, längere reviews werden vermieden</span>
- <span style="color: #8dfc8d;">Gerade als Junior Entwickler lernt man seinen Standpunkt zu argumentieren</span>
- <span style="color: #8dfc8d;">Weitergabe von Coding Patterns</span>


<!--
Ausbau von Soft skills, förderung von kommunikation im Team
-->

---
transition: slide-up
layout: center
class: text-white 
---

# Beispiele

---
transition: slide-up
layout: center
class: text-white 
---

# Hilfreiche Lektüre

https://google.github.io/eng-practices/review/reviewer/standard.html
<br>
https://google.github.io/eng-practices/review/reviewer/looking-for.html
<br>
https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/getting-started/helping-others-review-your-changes


---
transition: slide-up
layout: center
class: text-white 
---
# Danke für eure Aufmerksamkeit!