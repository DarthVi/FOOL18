push 0
push 1
push 6
push 2
push classciccio
new
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
halt

function0:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
push 0 
lfp
add
lw
calchoff
add
lw
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 1
push 0 
lfp
add
lw
calchoff
add
lw
push 2
push 0 
lfp
add
lw
calchoff
add
lw
add
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 2
push -2
lfp
add
lw
push 1
push 0 
lfp
add
lw
calchoff
add
lw
push 2
push 0 
lfp
add
lw
calchoff
add
lw
add
add
srv
pop
sra
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 54
srv
sra
pop
sfp
lrv
lra
js
classciccio2:
function2
function4
classciccio:
function2
function3
classpippo:
function0
function1
