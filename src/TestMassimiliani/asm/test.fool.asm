push 0
push function4
lfp
lfp
push -2
lfp
add
lw
js
halt

function0:
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
push 2
push 0
lfp
add
lw
calchoff
add
lw
sub
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
mult
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
div
srv
sra
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 10
push 5
push 2
push classA
new
push 1
srv
pop
sra
pop
sfp
lrv
lra
js
classA:
function0
function1
function2
function3
classnull:
